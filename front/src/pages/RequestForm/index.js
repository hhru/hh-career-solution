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
import fetchAdvisers from "src/services/fetchAdvisers";

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
  const [activeStep, setActiveStep] = React.useState(3);
  const steps = getSteps();
  const registerCustomerForm = useSelector(({ registerCustomerForm }) => registerCustomerForm);

  const handleNext = () => {
    setActiveStep((prevActiveStep) => {
      if (prevActiveStep + 1 === 4) {
        console.log(prevActiveStep + 1, registerCustomerForm);
        sendRegisterCustomer({
          username: registerCustomerForm.email,
          password: registerCustomerForm.password,
        });
        sendLoginCustomer({
          username: registerCustomerForm.email,
          password: registerCustomerForm.password,
        });
        fetchAdvisers({

        });
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
