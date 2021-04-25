import React from "react";

import { Container, Grid, Button, Typography } from "@material-ui/core";

import css from "./styles.module.scss";

const items = [
  {
    key: 1,
    title: "Инвестируете в карьеру",
    p1:
      "В среднем в РФ люди ищут новую работу 7 месяцев, т.е. теряет 7 новых зарплат",
    p2:
      "Вы инвестируете в 5 занятий, находите работу на 2-3 месяца быстрее и начинаете зарабатываете",
  },
  {
    key: 2,
    title: "Пытаетесь срезать путь",
    p1: "Меньше чем за 5 занятий никто не сможет разобраться в вашей карьере",
    p2:
      "Меньше чем за 5 занятий вы не сможете получить инсайты для достижения своей цели",
  },
];

const LandingWhyNeedSessionSlide = () => {
  return (
    <section className={css.whyNeedSession}>
      <Container maxWidth="md">
        <Typography variant="h5" component="h2">
          Почему нужно 5 занятий?
        </Typography>
        <Grid container className={css.list}>
          {items.map((item) => {
            return (
              <Grid
                key={item.key}
                className={css.listItem}
                item
                xs={12}
                sm={6}
                md={6}
              >
                <Typography
                  variant="subtitle1"
                  component="p"
                  className={css.itemSubtitle}
                >
                  <b>{item.title}</b>
                </Typography>
                <Typography
                  variant="body1"
                  component="p"
                  className={css.itemParagraph}
                >
                  {item.p1}
                </Typography>
                <Typography
                  variant="body1"
                  component="p"
                  className={css.itemParagraph}
                >
                  {item.p2}
                </Typography>
              </Grid>
            );
          })}
        </Grid>
        <Button variant="contained" color="secondary" size="large">
          Заказать консультацию
        </Button>
      </Container>
    </section>
  );
};

export default LandingWhyNeedSessionSlide;
