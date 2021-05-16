import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  MobileStepper, Stepper, Step, StepLabel, Button, Typography, Container, Grid
} from '@material-ui/core';
import RequestFormStepOne from 'src/components/RequestFormStepOne';
import RequestFormStepTwo from 'src/components/RequestFormStepTwo';
import RequestFormStepThree from 'src/components/RequestFormStepThree';
import RequestFormStepFour from 'src/components/RequestFormStepFour';
import RequestFormStepFive from 'src/components/RequestFormStepFive';

import sendRegisterCustomer from 'src/services/sendRegisterCustomer';
import sendLoginCustomer from 'src/services/sendLoginCustomer';
import sendCustomerProblem from 'src/services/sendCustomerProblem';
import fetchAdvisers from "src/services/fetchAdvisers";
import area from "../../redux/Area";

function getSteps() {
  return [
    'Формат',
    'Опыт работы',
    'Запрос 1/2',
    'Запрос 2/2',
    'Специалисты'
  ];
}

function getStepContent(stepIndex) {
  switch (stepIndex) {
    case 0:
      return (
        <RequestFormStepOne />
      );
    case 1:
      return (
        <RequestFormStepTwo />
      )
    case 2:
      return (
        <RequestFormStepThree />
      );
    case 3:
      return (
        <RequestFormStepFour />
      );
    case 4:
      return (
        <RequestFormStepFive />
      );
    default:
      return 'Unknown stepIndex';
  }
}

const RequestForm = () => {
  const defaultStep = 0; // 3
  const [activeStep, setActiveStep] = React.useState(defaultStep);
  const [sendRequestForm, setSendRequestForm] = React.useState(false);
  const steps = getSteps();
  const registerCustomerForm = useSelector(({ registerCustomerForm }) => registerCustomerForm);
  const requestForm = useSelector(({ requestForm }) => requestForm);
  const specialization = useSelector(({ specialization }) => specialization);
  const area = useSelector(({ area }) => area);
  // const advisers = useSelector(({ advisers }) => advisers);

  const dispatch = useDispatch();
  useEffect(() => {
    if (sendRequestForm) {
      // если уже залогинен скипнуть...
      dispatch(sendRegisterCustomer({
        username: registerCustomerForm.email,
        password: registerCustomerForm.password,
      }));
      setTimeout(() => {
        dispatch(sendLoginCustomer({
          username: registerCustomerForm.email,
          password: registerCustomerForm.password,
        }));
      }, 200);
      setTimeout(() => {
        dispatch(sendCustomerProblem({
          areaId: area.areaId,
          specializationId: Number(specialization.specializationId.split('.')[1]),
          consultationType: requestForm.consultationType,
          experience: requestForm.experience,
          careerPractice: 'CONSULTATION', //string of 'CONSULTATION', 'COACHING', 'ALL',
          customerType: requestForm.customerType
        }));
      }, 400);
      setSendRequestForm(false);
    }
  }, [sendRequestForm]);

  const handleNext = () => {
    setActiveStep((prevActiveStep) => {
      if (prevActiveStep + 1 === 4) {
        setSendRequestForm(true);
        return prevActiveStep + 1;
      } else {
        return prevActiveStep + 1;
      }
    });
  };

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1);
  };

  const handleReset = () => {
    setActiveStep(0);
  };

  return (
    <div>
      {activeStep !== steps.length ? (
        <div>
          {getStepContent(activeStep)}
        </div>
      ) : (
        <React.Fragment>
          Форма оплаты...
        </React.Fragment>
      )}
      <div>
        {activeStep === steps.length ? (
          <div>
            <Typography>Форма заполнена</Typography>
            <Button onClick={handleReset}>Сбросить</Button>
          </div>
        ) : (
          <div>
            <div>
              <Button
                disabled={activeStep === 0}
                onClick={handleBack}
              >
                Назад
              </Button>
              <Button variant="contained" color="primary" onClick={handleNext}>
                {activeStep === steps.length - 1 ? 'Отправить' : 'Дальше'}
              </Button>
            </div>
          </div>
        )}
      </div>
      <Stepper activeStep={activeStep} alternativeLabel variant="progress">
        {steps.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>
    </div>
  );
};

export default RequestForm;
