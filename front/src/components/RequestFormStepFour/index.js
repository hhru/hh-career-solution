import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Typography, Grid
} from '@material-ui/core';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogTitle from '@material-ui/core/DialogTitle';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import Checkbox from '@material-ui/core/Checkbox';
import TextField from '@material-ui/core/TextField';
import Input from '@material-ui/core/Input';
import InputLabel from '@material-ui/core/InputLabel';
import IconButton from '@material-ui/core/IconButton';
import InputAdornment from '@material-ui/core/InputAdornment';
import Visibility from '@material-ui/icons/Visibility';
import VisibilityOff from '@material-ui/icons/VisibilityOff';
import Policy from 'src/components/Policy';

import { setRegisterCustomerForm } from "src/redux/RegisterCustomerForm";

const RequestFormStepFour = () => {
  const dispatch = useDispatch();

  const registerCustomerForm = useSelector(({ registerCustomerForm }) => registerCustomerForm);

  const [showPassword, setShowPassword] = useState(false);
  const handleClickShowPassword = () => {
    setShowPassword(!showPassword);
  }

  const [modalVisible, setModalVisible] = useState(false);
  const handleModalOpen = () => {
    setModalVisible(true);
  };
  const handleModalClose = () => {
    setModalVisible(false);
  };

  return (
    <Grid container spacing={3} alignItems="center" justify="center">
      <Typography variant="h5" component="h2">
        Чтобы мы могли вам рекомендовать специалистов, заполните информацию о себе:
        </Typography>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <TextField
            id="name"
            label="Как вас зовут:"
            value={registerCustomerForm.fullName}
            onChange={(event) => {
              dispatch(setRegisterCustomerForm({ fullName: event.target.value }));
            }}
          />
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <TextField
            id="email"
            label="Укажите E-mail:"
            value={registerCustomerForm.email}
            onChange={(event) => {
              dispatch(setRegisterCustomerForm({ email: event.target.value }));
            }}
          />
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <TextField
            id="phone"
            label="Укажите телефон:"
            value={registerCustomerForm.phone}
            onChange={(event) => {
              dispatch(setRegisterCustomerForm({ phone: event.target.value }));
            }}
          />
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel htmlFor="password">Пароль:</InputLabel>
          <Input
            id="password"
            type={showPassword ? 'text' : 'password'}
            value={registerCustomerForm.password}
            onChange={(event) => {
              dispatch(setRegisterCustomerForm({ password: event.target.value }));
            }}
            endAdornment={
              <InputAdornment position="end">
                <IconButton
                  aria-label="toggle password visibility"
                  onClick={handleClickShowPassword}
                >
                  {showPassword ? <Visibility /> : <VisibilityOff />}
                </IconButton>
              </InputAdornment>
            }
          />
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl fullWidth>
          <InputLabel htmlFor="repeatPassword">Повторите пароль:</InputLabel>
          <Input
            id="repeatPassword"
            type={showPassword ? 'text' : 'password'}
            value={registerCustomerForm.repeatPassword}
            onChange={(event) => {
              dispatch(setRegisterCustomerForm({ repeatPassword: event.target.value }));
            }}
            endAdornment={
              <InputAdornment position="end">
                <IconButton
                  aria-label="toggle repeatPassword visibility"
                  onClick={handleClickShowPassword}
                >
                  {showPassword ? <Visibility /> : <VisibilityOff />}
                </IconButton>
              </InputAdornment>
            }
          />
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <FormControl component="fieldset" fullWidth>
          <FormLabel>Через какой мессенджер вам удобнее общаться:</FormLabel>
          <RadioGroup
            aria-label="messenger"
            name="messenger"
            value={registerCustomerForm.messanger}
            onChange={(event) => {
              dispatch(setRegisterCustomerForm({ messanger: event.target.value }));
            }}
          >
            {registerCustomerForm.messangerList.map((item) => (
              <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                {item.name}
              </FormControlLabel>
            ))}
          </RadioGroup>
        </FormControl>
      </Grid>
      <Grid item xs={12} sm={8}>
        <div style={{ display: "flex", justifyContent: "center" }}>
          <Typography component="div" style={{ padding: "5px 16px" }}>Я согласен с <Button color="secondary" onClick={handleModalOpen}>
            политикой </Button> обработки персональных данных:</Typography>
          <Dialog open={modalVisible} onClose={handleModalClose}>
            <DialogTitle id="simple-dialog-title">Политика в отношении обработки персональных данных</DialogTitle>
            <Policy />
          </Dialog>
          <FormControlLabel
            control={
              <Checkbox
                checked={registerCustomerForm.isUserPolicyConfirm}
                onChange={(event) => {
                  dispatch(setRegisterCustomerForm({ isUserPolicyConfirm: event.target.checked }));
                }}
                name="isUserPolicyConfirm"
                color="secondary"
              />
            }
            label=""
          />
        </div>
      </Grid>
    </Grid>
  );
}

export default RequestFormStepFour;
