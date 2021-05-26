import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Typography, Grid
} from '@material-ui/core';
import FormControl from '@material-ui/core/FormControl';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';

import fetchTags from "src/services/fetchTags";
import { setTags } from "src/redux/Tags";

const RequestFormStepThree = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(fetchTags());
  }, []);
  const tags = useSelector(({ tags }) => tags);

  return (
    <Grid container spacing={3} alignItems="center" justify="center">
      <Typography variant="h5" component="h2">Опишите свою проблему с помощью тегов:</Typography>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel id="lessInterviewIds">У меня мало собеседований:</InputLabel>
          <Select
            id="lessInterviewsIdsInput"
            labelId="lessInterviewIds"
            value={tags.lessInterviewIds}
            multiple
            onChange={(event) => {
              dispatch(setTags({ lessInterviewIds: event.target.value }));
            }}
            fullWidth
            required
          >
            {tags.lessInterviews.map((item) => (
              <MenuItem key={item.id} value={item.id}>
                {item.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel id="qualifyingStageIds">Я не знаю как проходят отборочные этапы:</InputLabel>
          <Select
            id="qualifyingStageIdsInput"
            labelId="qualifyingStageIds"
            value={tags.qualifyingStageIds}
            multiple
            onChange={(event) => {
              dispatch(setTags({ qualifyingStageIds: event.target.value }));
            }}
            fullWidth
            required
          >
            {tags.qualifyingStages.map((item) => (
              <MenuItem key={item.id} value={item.id}>
                {item.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel id="refuseIds">Мне отказывают после собеседования:</InputLabel>
          <Select
            id="refuseIdsInput"
            labelId="refuseIds"
            value={tags.refuseIds}
            multiple
            onChange={(event) => {
              dispatch(setTags({ refuseIds: event.target.value }));
            }}
            fullWidth
            required
          >
            {tags.refuse.map((item) => (
              <MenuItem key={item.id} value={item.id}>
                {item.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel id="badConditionIds">Предлагают не подходяие условия:</InputLabel>
          <Select
            id="badConditionIdsInput"
            labelId="badConditionIds"
            value={tags.badConditionIds}
            multiple
            onChange={(event) => {
              dispatch(setTags({ badConditionIds: event.target.value }));
            }}
            fullWidth
            required
          >
            {tags.badConditions.map((item) => (
              <MenuItem key={item.id} value={item.id}>
                {item.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel id="developmentIds">Развитие в компании, стратегия развития:</InputLabel>
          <Select
            id="developmentIdsInput"
            labelId="developmentIds"
            value={tags.developmentIds}
            multiple
            onChange={(event) => {
              dispatch(setTags({ developmentIds: event.target.value }));
            }}
            fullWidth
            required
          >
            {tags.development.map((item) => (
              <MenuItem key={item.id} value={item.id}>
                {item.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel id="newCareerIds">Развитие новой карьеры:</InputLabel>
          <Select
            id="newCareerIdsInput"
            labelId="newCareerIds"
            value={tags.newCareerIds}
            multiple
            onChange={(event) => {
              dispatch(setTags({ newCareerIds: event.target.value }));
            }}
            fullWidth
            required
          >
            {tags.newCareer.map((item) => (
              <MenuItem key={item.id} value={item.id}>
                {item.name}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Grid>
    </Grid>
  );
}

export default RequestFormStepThree;
