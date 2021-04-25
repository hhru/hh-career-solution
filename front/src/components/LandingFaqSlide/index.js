import React from "react";

import { Typography, Container } from "@material-ui/core";

import css from "./styles.module.scss";

const LandingFaqSlide = () => {
  return (
    <section className={css.faq}>
      <Container>
        <Typography variant="h6" component="h2">
          Ответы на вопросы...
        </Typography>
      </Container>
    </section>
  );
};

export default LandingFaqSlide;
