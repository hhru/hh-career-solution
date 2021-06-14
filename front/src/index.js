import React from "react";
import ReactDOM from "react-dom";
import { Provider } from 'react-redux';
import { BrowserRouter } from "react-router-dom";

import { CssBaseline, ThemeProvider } from "@material-ui/core";
import { StylesProvider, jssPreset } from "@material-ui/core/styles";

import { create } from "jss";
import theme from "src/services/theme.js";
import store from './redux/store';
import PageLayout from "src/components/PageLayout";

const jss = create({
  ...jssPreset(),
  insertionPoint: document.getElementById("jss-insertion-point"),
});

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <BrowserRouter>
        <StylesProvider jss={jss}>
          <ThemeProvider theme={theme}>
            <CssBaseline />
            <PageLayout />
          </ThemeProvider>
        </StylesProvider>
      </BrowserRouter>
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);
