import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import { Typography } from '@material-ui/core';
import css from './styles.module.scss';

const items = [
  {
    key: 1,
    title: 'Подбираем специалиста за 5 минут',
    message: 'Вам не надо долго листать каталоги и опрашивать друзей в поисках подходящего специалиста'
  },
  {
    key: 2,
    title: 'Ориентируемся гибко на ваш запрос',
    message: 'Карьерный наставник подбирается индивидуально под ваш запрос и сферу деятельности'
  },
  {
    key: 3,
    title: 'Мы отобрали лучших специалистов',
    message: 'Вы будете заниматься с профессионалом, только 20% специалистов проходят отбор'
  },
  {
    key: 4,
    title: 'У нас отработанная методика',
    message: 'Мы стандартизировали план сессий, а карьерный наставник учитывает ваш личный опыт'
  }
];

const LandingFirstSlide = () => {
  return (
    <section className={css.advantages}>
      <Container maxWidth="md">
        <Typography variant="h6" component="h2">
          Почему выбирают нас?
        </Typography>
        <Grid container className={css.list}>
          {items.map((item) => {
            return (
              <Grid key={item.key} className={css.item} item xs={12} sm={6} md={6}>
                <Typography variant="subtitle1" component="p">
                  <b>{item.title}</b>
                </Typography>
                <Typography className={css.itemText} variant="body1" component="p">
                  {item.message}
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
}

export default LandingFirstSlide;
