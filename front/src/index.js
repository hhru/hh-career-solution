import reportWebVitals from './reportWebVitals';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import { PrivateRoute } from './router/PrivateRoute';
import { CssBaseline, ThemeProvider } from '@material-ui/core';
import SignIn from './pages/SignIn';
import SignUp from './pages/SignUp';
import SignOut from './pages/SignOut';
import Landing from './pages/Landing';
import NotFound from './pages/NotFound';
import PageLayout from './components/PageLayout';
import theme from './services/theme.js';
import fakeAuth from './services/fakeAuth';
import { create } from 'jss';
import { StylesProvider, jssPreset } from '@material-ui/core/styles';

const jss = create({
  ...jssPreset(),
  insertionPoint: document.getElementById('jss-insertion-point'),
});

const isAuthenticated = fakeAuth.isAuthenticated;

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <StylesProvider jss={jss}>
        <ThemeProvider theme={theme}>
          <CssBaseline />
          <PageLayout>
            <Switch>
              <Route exact path="/sign-in" render={() => (!isAuthenticated ? <SignIn /> : <Redirect to="/" />)} />
              <Route exact path="/sign-up" component={SignUp} />
              <PrivateRoute exact path="/sign-out" isAuthenticated={isAuthenticated} Component={SignOut} />
              <Route exact path="/" component={Landing} />
              <PrivateRoute exact path="/protected" isAuthenticated={isAuthenticated} Component={() => (<h3>Protected</h3>)} />
              <Route component={NotFound} />
            </Switch>
          </PageLayout>
        </ThemeProvider>
      </StylesProvider>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

reportWebVitals();
