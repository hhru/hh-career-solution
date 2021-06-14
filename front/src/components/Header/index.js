import React from "react";
import { Link, useHistory } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';

import { Hidden, Typography, Container, Grid, Button } from "@material-ui/core";

import css from "./styles.module.scss";
import { setAuth } from "src/redux/Auth";

const Header = () => {
  const auth = useSelector(({ auth }) => auth);
  const dispatch = useDispatch();
  const isAuthenticated = auth.isAuthenticated;
  let history = useHistory();

  return (
    <header className={css.appHeader}>
      <Container>
        <Grid container alignItems="center">
          <Grid item xs={4} sm={6} md={5}>
            <Grid container alignItems="center" direction="row" wrap="nowrap">
              <Link to={`/`} className={css.headerLink}>
                <Typography
                  className={css.header}
                  variant="h3"
                  component="h1"
                  color="secondary"
                >
                  Lift
                </Typography>
              </Link>
              <Hidden only="xs">
                <Typography
                  className={css.subHeader}
                  variant="caption"
                  component="span"
                >
                  сервис карьерных&nbsp;наставников
                </Typography>
              </Hidden>
            </Grid>
          </Grid>
          <Grid className={css.fill} item />
          <Grid className={css.buttonWrapper} item>
            {isAuthenticated && (
              <Button className={css.button} variant="outlined" color="secondary" onClick={() => {
                dispatch(setAuth({ isAuthenticated: false, isAdviser: false, isCustomer: false }));
                history.push("/");
              }}>
                Выйти
              </Button>
            )}
            {!isAuthenticated && (
              <Link to={`/sign-in`} className={css.headerLink}>
                <Button className={css.button} variant="outlined" color="secondary">
                  Войти
                </Button>
              </Link>
            )}
          </Grid>
        </Grid>
      </Container>
    </header>
  );
};

export default Header;
