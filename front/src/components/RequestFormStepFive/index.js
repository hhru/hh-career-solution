import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Typography, Grid, Card, CardContent, CardMedia
} from '@material-ui/core';
import Accent from "src/components/Accent";

import css from "./styles.module.scss";
import fetchMessangerList from "src/services/fetchMessangerList";
import { getSpecialization, getExperience } from 'src/services/renderHelpers';

const RequestFormStepFive = () => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(fetchMessangerList());
  }, []);

  const advisers = useSelector(({ advisers }) => advisers.list);

  return (
    <React.Fragment>
      <Typography variant="h5" component="h2">Выберите подходящего специалиста</Typography>
      {advisers.length > 0 && (
        <Typography variant="h6" component="h3">Мы выбрали наиболее подходящих специалистов на основе вашего запроса</Typography>
      )}
      <Grid container justify="center" className={css.wrapContainer}>
        {advisers.length === 0 && (
          <Typography variant="h6" component="h3"><Accent>По вашему запросу специалистов не найдено</Accent></Typography>
        )}
        {advisers.map((item) => {
          return (
            <Grid key={item.id} item xs={12} md={6} lg={4}>
              <div className={css.itemWrapper}>
                <Card className={css.card}>
                  <CardMedia
                    className={css.cardMedia}
                    image={item.imageUrl}
                    title={item.name + " " + item.surname}
                  />
                  <CardContent>
                    <Typography
                      variant="body1"
                      color="textSecondary"
                      component="p"
                    >
                      {item.name + " " + item.surname}
                    </Typography>
                    <Typography
                      variant="body1"
                      color="textSecondary"
                      component="p"
                    >
                      {getExperience(item)}
                    </Typography>
                    <Typography
                      variant="body1"
                      color="textSecondary"
                      component="p"
                    >
                      {getSpecialization(item)}
                    </Typography>
                  </CardContent>
                </Card>
              </div>
            </Grid>
          );
        })}
      </Grid>
    </React.Fragment>
  );
}

export default RequestFormStepFive;
