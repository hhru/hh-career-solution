import { Typography } from "@material-ui/core";
import Container from "@material-ui/core/Container";
import Grid from "@material-ui/core/Grid";
import css from "./styles.module.scss";
import React from "react";
import okImg from './Ok-pana.png';
import secureImg from './Secure_data-pana.png';
import upgradeImg from './Upgrade-pana.png';

const items = [
  {
    key: 1,
    imgSrc: secureImg,
    imgAlt: "secure",
    step: "1.",
    message: "Вы описываете проблему",
  },
  {
    key: 2,
    imgSrc: okImg,
    imgAlt: "ok",
    step: "2.",
    message: "Мы подбираем наставника",
  },
  {
    key: 3,
    imgSrc: upgradeImg,
    imgAlt: "upgrade",
    step: "3.",
    message: "Вы улучшаете карьеру",
  },
];

const LandingHowItWorksSlide = () => {
  return (
    <section className={css.howItWorks}>
      <Container>
        <Typography variant="h5" component="h2">
          Как работает сервис?
        </Typography>
        <Grid container>
          {items.map((item) => {
            return (
              <Grid key={item.key} item xs={12} md={4}>
                <Grid
                  container
                  className={css.itemWrapper}
                  justify="center"
                  alignItems="center"
                  spacing={2}
                >
                  <Grid item md={12}>
                    <img
                      className={css.itemImg}
                      src={item.imgSrc}
                      alt={item.imgAlt}
                    />
                  </Grid>
                  <Grid className={css.itemContent} item md={12}>
                    <Typography>
                      <span className={css.itemStep}>{item.step}</span>
                      {item.message}
                    </Typography>
                  </Grid>
                </Grid>
              </Grid>
            );
          })}
        </Grid>
      </Container>
    </section>
  );
};

export default LandingHowItWorksSlide;
