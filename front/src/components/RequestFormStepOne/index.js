import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Container, Grid
} from '@material-ui/core';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';

import fetchAreas from "src/services/fetchAreas";
import fetchConsultationType from "src/services/fetchConsultationType";
import { setRequestForm } from "src/redux/RequestForm";
import { setCountryId, setRegionId, setCityId } from "src/redux/Area";

const RequestFormStepOne = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(fetchAreas());
    dispatch(fetchConsultationType());
  }, []);

  const area = useSelector(({ area }) => area);
  const requestForm = useSelector(({ requestForm }) => requestForm);
  console.log(area, requestForm);

  return (
    <Container maxWidth="md" style={{ padding: "50px 10px" }}>
      <Grid container spacing={3} alignItems="center" justify="center">
        <Grid item xs={12} sm={8}>
          <FormControl component="fieldset" fullWidth>
            <FormLabel>Выберите в каком формате вам удобнее заниматься</FormLabel>
            <RadioGroup
              aria-label="format"
              name="format"
              value={requestForm.consultationType}
              onChange={(event) => {
                dispatch(setRequestForm({ consultationType: event.target.value }));
              }}
            >
              {requestForm.consultationTypeList.map((item) => (
                <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                  {item.name}
                </FormControlLabel>
              ))}
            </RadioGroup>
          </FormControl>
        </Grid>
        <React.Fragment>
          <Grid item xs={12} sm={8}>
            <FormControl fullWidth>
              <InputLabel id="city-label">В каком городе вы живете?</InputLabel>
              <Select
                id="country"
                labelId="country-label"
                value={area.countryId}
                onChange={(event) => {
                  dispatch(setCountryId(event.target.value));
                }}
                fullWidth
                required
              >
                {area.countries.map((item) => (
                  <MenuItem key={item.id} value={item.id}>
                    {item.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
          </Grid>
          {area.regions.length > 0 &&
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <Select
                  id="region"
                  labelId="region-label"
                  value={area.regionId}
                  onChange={(event) => {
                    dispatch(setRegionId(event.target.value));
                  }}
                  fullWidth
                  required
                >
                  {area.regions.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
          }
          {area.cities.length > 0 &&
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <Select
                  id="city"
                  labelId="city-label"
                  value={area.cityId}
                  onChange={(event) => {
                    dispatch(setCityId(event.target.value));
                  }}
                  fullWidth
                  required
                >
                  {area.cities.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>}
        </React.Fragment >
      </Grid>
    </Container>
  );
}

export default RequestFormStepOne;
