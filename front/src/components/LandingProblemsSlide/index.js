import React from "react";

import { Container, Grid, List, ListItem, ListItemText, Typography } from '@material-ui/core';

import css from './styles.module.scss';

const items = [
  {
    key: 1,
    message: "Рассылаю резюме, но не приглашают на собеседования"
  },
  {
    key: 2,
    message: "Есть собеседования, но предлагают не те компании, не ту зарплату и не ту должность"
  },
  {
    key: 3,
    message: "Был большой перерыв в карьере и не знаю как найти подходящую работу"
  },
  {
    key: 4,
    message: "Задачи, которые делаю на работе, мне не нравятся"
  },
  {
    key: 5,
    message: "Боюсь за свою карьеру, потому что не знаю куда дальше двигаться"
  },
]

const LandingProblemsSlide = () => {
  return (
    <section className={css.problems}>
      <Container maxWidth="md">
        <Grid container>
          <Grid item xs={12}>
            <Typography variant="h5" component="h2">
              Чаще всего к нам обращаются с такими проблемами:
            </Typography>
            <Grid container alignItems="center" justify="center">
              <List className={css.list}>
                {items.map((item) => {
                  return (
                    <ListItem key={item.key}>
                      <ListItemText primary={item.message} />
                    </ListItem>
                  );
                })}
              </List>
            </Grid>
          </Grid>
        </Grid>
      </Container>
    </section>
  );
}

export default LandingProblemsSlide;
