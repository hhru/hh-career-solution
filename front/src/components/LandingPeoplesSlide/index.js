import { Card, CardContent, CardMedia, Typography, Button } from '@material-ui/core';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import React from 'react';
import css from './styles.module.scss';

const items = [
  {
    key: 1,
    imgSrc: "people1.jpg",
    name: "Светлана Н.",
    position: "Ит-рекрутер",
    experience: "7 лет",
    specialization: "Карьерный консультант в IT",
  },
  {
    key: 5,
    imgSrc: "people5.jpg",
    name: "Сергей С.",
    position: "Стратегический консультант",
    experience: "13 лет",
    specialization: "Карьерный коуч",
  },
  {
    key: 2,
    imgSrc: "people2.jpg",
    name: "Вера О.",
    position: "HR-менеджер",
    experience: "8 лет",
    specialization: "Карьерный коуч",
  },
  {
    key: 4,
    imgSrc: "people4.jpg",
    name: "Татьяна А.",
    position: "Рекрутер",
    experience: "11 лет",
    specialization: "Карьерный консультант в финансах",
  },
  {
    key: 3,
    imgSrc: "people3.jpg",
    name: "Евгения С.",
    position: "Рекрутер",
    experience: "9 лет",
    specialization: "Карьерный консультант в производстве",
  },
  {
    key: 6,
    imgSrc: "people6.jpg",
    name: "Михаил В.",
    position: "Бизнес-консультант",
    experience: "12 лет",
    specialization: "Карьерный консультант в маркетинге",
  },
];

const LandingPeoplesSlide = () => {
  return (
    <section className={css.peoples}>
      <Container>
        <Grid container>
          <Grid item xs={12}>
            <Typography variant="h5" component="h2">
              Мы нашли лучших экспертов в сфере развития карьеры
            </Typography>
            <Typography variant="h6" component="h3" className={css.wrapSubTitle}>
              2 из 10 становятся нашими сотрудниками
            </Typography>
            <Grid container justify="center" className={css.wrapContainer}>
              {items.map((item) => {
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
                          <Typography variant="body1" color="textSecondary" component="p">
                            {item.name}
                          </Typography>
                          <Typography variant="body1" color="textSecondary" component="p">
                            {item.position}, {item.experience}
                          </Typography>
                          <Typography variant="body1" color="textSecondary" component="p">
                            {item.specialization}
                          </Typography>
                        </CardContent>
                      </Card>
                    </div>
                  </Grid>
                );
              })}
            </Grid>
            <Button variant="contained" color="secondary" size="large">
              Заказать консультацию
            </Button>
          </Grid>
        </Grid>
      </Container>
    </section>
  );
}

export default LandingPeoplesSlide;
