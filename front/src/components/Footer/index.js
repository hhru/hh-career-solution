import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import React from "react";
import css from "./styles.module.scss";
import { Grid } from "@material-ui/core";

const Footer = () => {
  return (
    <React.Fragment>
      <footer className={css.appFooter}>
        <Container>
          <Grid container alignItems="center">
            <Grid item>
              <Typography variant="body1">
                {"Copyright © "}
                Lift&nbsp;
                {new Date().getFullYear()}
                {"."}
              </Typography>
            </Grid>
            <Grid className={css.fill} item />
          </Grid>
        </Container>
      </footer>
    </React.Fragment>
  );
};

export default Footer;
