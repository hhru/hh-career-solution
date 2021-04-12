import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import css from './styles.module.scss';
import React from 'react';
import { Typography } from '@material-ui/core';
import Accent from '../Accent';

const items = [
  {
    'key': 1,
    'title': (<React.Fragment>Неделя&nbsp;1.</React.Fragment>),
    'message': (<React.Fragment><b>Вы знаете чего хотите.</b> Вместе со специалистом вы определяете, где работать, что делать дальше.</React.Fragment>)
  },
  {
    'key': 2,
    'title': (<React.Fragment>Неделя&nbsp;2.</React.Fragment>),
    'message': (<React.Fragment><b>Вы чувствуете себя увереннее.</b> Наставник находит сильные стороны, компетенции, навыки, оценивает потенциал.</React.Fragment>)
  },
  {
    'key': 3,
    'title': (<React.Fragment>Неделя&nbsp;3.</React.Fragment>),
    'message': (<React.Fragment><b>Вы имеете подходящий список работодателей.</b> Специалист вместе с вами анализирует компании, вакансии и рекомендует подходящие.</React.Fragment>)
  },
  {
    'key': 4,
    'title': (<React.Fragment>Неделя&nbsp;4.</React.Fragment>),
    'message': (<React.Fragment><b>Ваше резюме точно заметят.</b> Наставник помогает готовить резюме, сопроводительные письма, размещаете резюме в целевых каналах.</React.Fragment>)
  },
  {
    'key': 5,
    'title': (<React.Fragment>Неделя&nbsp;5.</React.Fragment>),
    'message': (<React.Fragment>Наставник готовит вас собеседованию, учитесь говорить о зраплате. <b>Вы готовы покорять карьерные вершины!</b></React.Fragment>)
  },
]

const LandingHowItHelpsSlide = () => {
  return (
    <section className={css.howItHelps}>
      <Container maxWidth="md">
        <Typography variant="h5" component="h2">
          Вы <Accent>улучшите свою карьеру за 5 недель</Accent> вместе с карьерным наставником
        </Typography>
        <Grid container className={css.list}>
          {items.map((item) => {
            return (
              <Grid key={item.key} item xs={12}>
                <Grid container spacing={2} className={css.item} >
                  <Grid className={css.itemTitle} item xs={12} sm={2}>
                    <Typography variant="body1" component="div">
                      <b>{item.title}</b>
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={10}>
                    <Typography variant="body1" component="div">
                      {item.message}
                    </Typography>
                  </Grid>
                </Grid>
              </Grid>
            );
          })}
        </Grid>
      </Container>
    </section >
  );
}

export default LandingHowItHelpsSlide;
