import { Typography } from "@material-ui/core";
import Container from "@material-ui/core/Container";
import css from "./styles.module.scss";
import React from "react";

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
