import React from "react";
import { useSelector, useDispatch } from 'react-redux';
import { Switch, Route, Redirect } from "react-router-dom";

import Header from "src/components/Header";
import Footer from "src/components/Footer";
import { PrivateRoute } from "src/router/PrivateRoute";
import SignIn from "src/pages/SignIn";
import SignUp from "src/pages/SignUp";
import Landing from "src/pages/Landing";
import NotFound from "src/pages/NotFound";
import RequestForm from "src/pages/RequestForm";
import CustomerMain from "src/pages/CustomerMain";
import AdviserMain from "src/pages/AdviserMain";

import css from "./styles.module.scss";

const PageLayout = () => {
  const auth = useSelector(({ auth }) => auth);

  const isAuthenticated = auth.isAuthenticated;
  const isAdviser = auth.isAdviser;
  const isCustomer = auth.isCustomer;
  const homeRoute = auth.homeRoute;

  return (
    <React.Fragment>
      <Header />
      <div className={css.app}>
        <Switch>
          <Route
            exact
            path="/sign-in"
            render={() =>
              !isAuthenticated ? <SignIn /> : <Redirect to={homeRoute} />
            }
          />
          <Route exact path="/sign-up" component={SignUp} />
          <Route exact path="/request-form" component={RequestForm} />
          <Route exact path="/" component={Landing} />
          <PrivateRoute
            exact
            path="/customer/cabinet"
            isAuthenticated={isAuthenticated && isCustomer}
            Component={CustomerMain}
          />
          <PrivateRoute
            exact
            path="/adviser/cabinet"
            isAuthenticated={isAuthenticated && isAdviser}
            Component={AdviserMain}
          />
          <Route component={NotFound} />
        </Switch>
      </div>
      <Footer />
    </React.Fragment>
  );
};

export default PageLayout;
