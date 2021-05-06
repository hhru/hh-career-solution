import React from "react";

import Header from "src/components/Header";
import Footer from "src/components/Footer";

import css from "./styles.module.scss";

const PageLayout = ({ children }) => {
  return (
    <React.Fragment>
      <Header />
      <div className={css.app}>{children}</div>
      <Footer />
    </React.Fragment>
  );
};

export default PageLayout;
