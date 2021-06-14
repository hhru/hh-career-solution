import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Avatar, Button, TextField, Typography, Container, FormControl, FormLabel
} from '@material-ui/core';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';

import classes from './styles.module.scss';
import sendLoginCustomer from 'src/services/sendLoginCustomer';

const SignIn = () => {
  const dispatch = useDispatch();
  const [login, setLogin] = useState('');
  const [password, setPassword] = useState('');
  const handleSubmit = () => {
    dispatch(sendLoginCustomer({
      username: login,
      password: password,
    }));
  };

  return (
    <Container component="main" maxWidth="xs">
      <div className={classes.paper}>
        <Avatar className={classes.avatar}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Sign in
        </Typography>
        <FormControl component="fieldset" fullWidth>
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            id="login"
            label="login"
            value={login}
            onChange={(event) => {
              setLogin(event.target.value);
            }}
            autoComplete="login"
            autoFocus
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            fullWidth
            label="Password"
            type="password"
            id="password"
            value={password}
            onChange={(event) => {
              setPassword(event.target.value);
            }}
            autoComplete="current-password"
          />
        </FormControl>
        <Button
          fullWidth
          variant="contained"
          color="primary"
          className={classes.submit}
          onClick={handleSubmit}
        >
          Sign In
        </Button>
      </div>
    </Container>
  );
};

export default SignIn;
