import { Typography } from '@material-ui/core';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import css from './styles.module.scss';

const items = [
  {
    key: 1,
    imgSrc: "Secure_data-pana.png",
    imgAlt: "secure",
    step: "1.",
    message: "Вы описываете проблему",
  },
  {
    key: 2,
    imgSrc: "Ok-pana.png",
    imgAlt: "ok",
    step: "2.",
    message: "Мы подбираем наставника",
  },
  {
    key: 3,
    imgSrc: "Upgrade-pana.png",
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
                <Grid container className={css.itemWrapper} justify="center" alignItems="center" spacing={2}>
                  <Grid item md={12}>
                    <img className={css.itemImg} src={item.imgSrc} alt={item.imgAlt} />
                  </Grid>
                  <Grid className={css.itemContent} item md={12}>
                    <Typography>
                      <span className={css.itemStep}>
                        {item.step}
                      </span>
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
}

export default LandingHowItWorksSlide;
