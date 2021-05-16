import React from "react";
import ReactDOM from "react-dom";
import { Provider } from 'react-redux';
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";

import { CssBaseline, ThemeProvider } from "@material-ui/core";
import { StylesProvider, jssPreset } from "@material-ui/core/styles";

import { create } from "jss";
import theme from "src/services/theme.js";
import store from './redux/store';

import { PrivateRoute } from "src/router/PrivateRoute";
import fakeAuth from "src/services/fakeAuth";
import SignIn from "src/pages/SignIn";
import SignUp from "src/pages/SignUp";
import SignOut from "src/pages/SignOut";
import Landing from "src/pages/Landing";
import NotFound from "src/pages/NotFound";
import RequestForm from "src/pages/RequestForm";
import PageLayout from "src/components/PageLayout";

const jss = create({
  ...jssPreset(),
  insertionPoint: document.getElementById("jss-insertion-point"),
});

const isAuthenticated = fakeAuth.isAuthenticated;

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <BrowserRouter>
        <StylesProvider jss={jss}>
          <ThemeProvider theme={theme}>
            <CssBaseline />
            <PageLayout>
              <Switch>
                <Route
                  exact
                  path="/sign-in"
                  render={() =>
                    !isAuthenticated ? <SignIn /> : <Redirect to="/" />
                  }
                />
                <Route exact path="/sign-up" component={SignUp} />
                <Route exact path="/request-form" component={RequestForm} />
                <PrivateRoute
                  exact
                  path="/sign-out"
                  isAuthenticated={isAuthenticated}
                  Component={SignOut}
                />
                <Route exact path="/" component={Landing} />
                <PrivateRoute
                  exact
                  path="/protected"
                  isAuthenticated={isAuthenticated}
                  Component={() => <h3>Protected</h3>}
                />
                <Route component={NotFound} />
              </Switch>
            </PageLayout>
          </ThemeProvider>
        </StylesProvider>
      </BrowserRouter>
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);
