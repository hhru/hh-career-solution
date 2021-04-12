import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';
import { Typography } from '@material-ui/core';
import Accent from '../Accent';
import css from './styles.module.scss';

const LandingGoalsSlide = () => {
  return (
    <section className={css.goal}>
      <Container>
        <Grid container alignItems="center" justify="center">
          <Grid item xs={12} sm={6}>
            <Typography className={css.mainText} variant="h5" component="div">
              Помогаем найти <Accent>дело&nbsp;по&nbsp;душе</Accent>,
              <br />найти <Accent>подходящую&nbsp;работу</Accent>
              <br />и получать <Accent>достойную&nbsp;зарплату</Accent>
            </Typography>
            <Button variant="contained" color="secondary" size="large">
              Заказать консультацию
            </Button>
          </Grid>
          <Grid item xs={12} sm={6}>
            <img className={css.mainImg} src="Career_progress-pana.png" alt="progress" />
          </Grid>
        </Grid>
      </Container>
    </section>
  );
}

export default LandingGoalsSlide;
