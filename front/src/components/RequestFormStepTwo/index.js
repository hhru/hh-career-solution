import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Grid
} from '@material-ui/core';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';

import fetchSpecializations from "src/services/fetchSpecializations";
import fetchCustomerTypeList from "src/services/fetchCustomerTypeList";
import fetchExperienceList from "src/services/fetchExperienceList";
import { setIndustryId, setSpecializationId } from "src/redux/Specialization";
import { setRequestForm } from "src/redux/RequestForm";

const RequestFormStepTwo = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(fetchSpecializations());
    dispatch(fetchCustomerTypeList());
    dispatch(fetchExperienceList());
  }, []);

  const specialization = useSelector(({ specialization }) => specialization);
  const requestForm = useSelector(({ requestForm }) => requestForm);

  return (
    <Grid container spacing={3} alignItems="center" justify="center">
      <React.Fragment>
        <Grid item xs={12} sm={8}>
          <FormControl fullWidth>
            <InputLabel id="industry-label">Выберите вашу специализацию:</InputLabel>
            <Select
              labelId="industry-label"
              value={specialization.industryId}
              onChange={(event) => {
                dispatch(setIndustryId(event.target.value));
              }}
              fullWidth
              required
            >
              {specialization.industries.map((item) => (
                <MenuItem key={item.id} value={item.id}>
                  {item.name}
                </MenuItem>
              ))}
            </Select>
          </FormControl>
        </Grid>
        {specialization.specializations.length > 0 &&
          <Grid item xs={12} sm={8}>
            <FormControl fullWidth>
              <Select
                id="specialization"
                labelId="specialization-label"
                value={specialization.specializationId}
                onChange={(event) => {
                  dispatch(setSpecializationId(event.target.value));
                }}
                fullWidth
                required
              >
                {specialization.specializations.map((item) => (
                  <MenuItem key={item.id} value={item.id}>
                    {item.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
          </Grid>
        }
      </React.Fragment >
      <Grid item xs={12} sm={8}>
        <FormControl component="fieldset" fullWidth>
          <FormLabel>Укажите ваш стаж работы:</FormLabel>
          <RadioGroup
            aria-label="experienceMark"
            name="experienceMark"
            value={requestForm.experience}
            onChange={(event) => {
              dispatch(setRequestForm({ experience: event.target.value }));
            }}
          >
            {requestForm.experienceList.map((item) => (
              <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                {item.name}
              </FormControlLabel>
            ))}
          </RadioGroup>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl component="fieldset" fullWidth>
          <FormLabel>Укажите ваш уровень позиции:</FormLabel>
          <RadioGroup
            aria-label="position"
            name="position"
            value={requestForm.customerType}
            onChange={(event) => {
              dispatch(setRequestForm({ customerType: event.target.value }));
            }}
          >
            {requestForm.customerTypeList.map((item) => (
              <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                {item.name}
              </FormControlLabel>
            ))}
          </RadioGroup>
        </FormControl>
      </Grid>
    </Grid>
  );
}

export default RequestFormStepTwo;
