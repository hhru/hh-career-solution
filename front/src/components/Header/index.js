import React from "react";

import { Hidden, Typography, Container, Grid, Button } from "@material-ui/core";

import css from "./styles.module.scss";

const Header = () => {
  return (
    <header className={css.appHeader}>
      <Container>
        <Grid container alignItems="center">
          <Grid item xs={4} sm={6} md={5}>
            <Grid container alignItems="center" direction="row" wrap="nowrap">
              <Typography
                className={css.header}
                variant="h3"
                component="h1"
                color="secondary"
              >
                Lift
              </Typography>
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
            <Button className={css.button} variant="outlined" color="secondary">
              Войти
            </Button>
          </Grid>
        </Grid>
      </Container>
    </header>
  );
};

export default Header;
