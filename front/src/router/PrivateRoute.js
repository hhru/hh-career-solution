import React from 'react';
import { Route, Redirect } from 'react-router-dom';

export const PrivateRoute = ({
  isAuthenticated,
  ...routeProps
}) => {
  return (
    <React.Fragment>
      <Route
        {...routeProps}
        render={(props) =>
          isAuthenticated ? (
            <routeProps.Component headingSettings={routeProps.headingSettings} {...props} />
          ) : (
            <Redirect to='/sign-in' />
          )
        }
      />
      {routeProps.childRoutes?.length &&
        routeProps.childRoutes.map((childRoute) => (
          <PrivateRoute key={childRoute.id} isAuthenticated={isAuthenticated} Component={childRoute.Component} {...childRoute} />
        ))}
    </React.Fragment>
  );
};
