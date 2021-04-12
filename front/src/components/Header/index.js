import css from './styles.module.scss';
import Hidden from '@material-ui/core/Hidden';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Button from '@material-ui/core/Button';

const Header = () => {
  return (
    <header className={css.appHeader}>
      <Container>
        <Grid container alignItems="center">
          <Grid item xs={4} sm={6} md={5}>
            <Grid container alignItems="center" direction="row" wrap="nowrap">
              <Typography className={css.header} variant="h3" component="h1" color="secondary">
                Lift
              </Typography>
              <Hidden only="xs">
                <Typography className={css.subHeader} variant="caption" component="span">
                  сервис карьерных&nbsp;наставников
                </Typography>
              </Hidden>
            </Grid>
          </Grid>
          <Grid className={css.fill} item />
          <Grid className={css.buttonWrapper} item>
            <Button className={css.button} variant="outlined" color="secondary">
              Войти
            </Button>
          </Grid>
        </Grid>
      </Container>
    </header >
  );
}

export default Header;
