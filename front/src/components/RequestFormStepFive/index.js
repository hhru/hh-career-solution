import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Typography, Container, Grid, Card, CardContent, CardMedia
} from '@material-ui/core';
import Accent from "src/components/Accent";

import css from "./styles.module.scss";
// import people2 from './people2.jpg';
// import people3 from './people3.jpg';
// import people5 from './people5.jpg';

const RequestFormStepFive = () => {
  // const advisers = [
  //   {
  //     key: 5,
  //     imgSrc: people5,
  //     name: "Сергей С.",
  //     position: "Стратегический консультант",
  //     experience: "13 лет",
  //     specialization: "Карьерный коуч",
  //   },
  //   {
  //     key: 2,
  //     imgSrc: people2,
  //     name: "Вера О.",
  //     position: "HR-менеджер",
  //     experience: "8 лет",
  //     specialization: "Карьерный коуч",
  //   },
  //   {
  //     key: 3,
  //     imgSrc: people3,
  //     name: "Евгения С.",
  //     position: "Рекрутер",
  //     experience: "9 лет",
  //     specialization: "Карьерный консультант в производстве",
  //   },
  // ];

  // const item = {
  //   "id": 1,
  //   "name": "Светлана",
  //   "surname": "Н.",
  //   "imageUrl": "https://disk.yandex.ru/i/HSwdKJ3CBSG10w",
  //   "experience": "NO_EXPERIENCE",
  //   "consultationType": "ONLINE",
  //   "careerPractice": "CONSULTATION",
  // }

  const advisers = useSelector(({ advisers }) => advisers.list);

  const getSpecialization = (item) => {
    const map = {
      'CONSULTATION': 'Карьерный консультант',
      'COACHING': 'Карьерный коуч',
      'ALL': 'Карьерный коуч и консультант',
    };
    return map[item.careerPractice];
  };

  const getExperience = (item) => {
    const map = {
      'NO_EXPERIENCE': 'опыт менее 1 года',
      'BETWEEN_1_AND_3': 'опыт от 1 года до 3 лет',
      'BETWEEN_3_AND_6': 'опыт от 3 лет до 6 лет',
      'MORE_THAN_6': 'опыт более 6 лет',
    };
    return map[item.experience];
  };

  return (
    <Container maxWidth="md" style={{ padding: "50px 10px" }}>
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
                      {/* {item.position}, {item.experience} */}
                      {getExperience(item)}
                    </Typography>
                    <Typography
                      variant="body1"
                      color="textSecondary"
                      component="p"
                    >
                      {/* {item.specialization} */}
                      {getSpecialization(item)}
                    </Typography>
                  </CardContent>
                </Card>
              </div>
            </Grid>
          );
        })}
      </Grid>
    </Container>
  );
}

export default RequestFormStepFive;