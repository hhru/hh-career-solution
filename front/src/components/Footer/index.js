import React from "react";

import { Grid, Typography, Container } from "@material-ui/core";

import css from "./styles.module.scss";

const Footer = () => {
  return (
    <React.Fragment>
      <footer className={css.appFooter}>
        <Container>
          <Grid container alignItems="center">
            <Grid item>
              <Typography variant="body1">
                {`© Lift ${new Date().getFullYear()}.`}
              </Typography>
            </Grid>
          </Grid>
        </Container>
      </footer>
    </React.Fragment>
  );
};

export default Footer;
