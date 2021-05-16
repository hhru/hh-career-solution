import React, { useState } from "react";

import {
  Typography, Container, Grid, Card, CardContent, CardMedia
} from '@material-ui/core';

import css from "./styles.module.scss";
import people2 from './people2.jpg';
import people3 from './people3.jpg';
import people5 from './people5.jpg';

const RequestFormStepFive = () => {
  const peoples = [
    {
      key: 5,
      imgSrc: people5,
      name: "Сергей С.",
      position: "Стратегический консультант",
      experience: "13 лет",
      specialization: "Карьерный коуч",
    },
    {
      key: 2,
      imgSrc: people2,
      name: "Вера О.",
      position: "HR-менеджер",
      experience: "8 лет",
      specialization: "Карьерный коуч",
    },
    {
      key: 3,
      imgSrc: people3,
      name: "Евгения С.",
      position: "Рекрутер",
      experience: "9 лет",
      specialization: "Карьерный консультант в производстве",
    },
  ];

  return (
    <Container maxWidth="md" style={{ padding: "50px 10px" }}>
      <Grid container spacing={3} alignItems="center" justify="center">
        <Typography variant="h5" component="h2">Выберите подходящего специалиста</Typography>
        <Typography variant="h6" component="h3">Мы выбрали наиболее подходящих специалистов на основе вашего запроса</Typography>
        <Grid container justify="center" className={css.wrapContainer}>
          {peoples.map((item) => {
            return (
              <Grid key={item.key} item xs={12} md={6} lg={4}>
                <div className={css.itemWrapper}>
                  <Card className={css.card}>
                    <CardMedia
                      className={css.cardMedia}
                      image={item.imgSrc}
                      title={item.name}
                    />
                    <CardContent>
                      <Typography
                        variant="body1"
                        color="textSecondary"
                        component="p"
                      >
                        {item.name}
                      </Typography>
                      <Typography
                        variant="body1"
                        color="textSecondary"
                        component="p"
                      >
                        {item.position}, {item.experience}
                      </Typography>
                      <Typography
                        variant="body1"
                        color="textSecondary"
                        component="p"
                      >
                        {item.specialization}
                      </Typography>
                    </CardContent>
                  </Card>
                </div>
              </Grid>
            );
          })}
        </Grid>
      </Grid>
    </Container>
  );
}

export default RequestFormStepFive;
