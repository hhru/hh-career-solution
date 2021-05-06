import React from "react";

import css from "./styles.module.scss";

const Accent = ({ children }) => {
  return <span className={css.accent}>{children}</span>;
};

export default Accent;
