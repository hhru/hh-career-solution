import React from "react";

import { Container, Grid, Typography, Button } from "@material-ui/core";
import Accent from "src/components/Accent";

import css from "./styles.module.scss";
import mainImg from './Career_progress-pana.png';

const LandingGoalsSlide = () => {
  return (
    <section className={css.goal}>
      <Container>
        <Grid container alignItems="center" justify="center">
          <Grid item xs={12} sm={6}>
            <Typography className={css.mainText} variant="h5" component="div">
              Помогаем найти <Accent>дело&nbsp;по&nbsp;душе</Accent>,
              <br />
              найти <Accent>подходящую&nbsp;работу</Accent>
              <br />и получать <Accent>достойную&nbsp;зарплату</Accent>
            </Typography>
            <Button variant="contained" color="secondary" size="large">
              Заказать консультацию
            </Button>
          </Grid>
          <Grid item xs={12} sm={6}>
            <img
              className={css.mainImg}
              src={mainImg}
              alt="progress"
            />
          </Grid>
        </Grid>
      </Container>
    </section>
  );
};

export default LandingGoalsSlide;
