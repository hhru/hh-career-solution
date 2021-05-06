import React, { useState } from "react";

import {
  Stepper, Step, StepLabel, Button, Typography, Container,
  Grid, Card, CardContent, CardMedia
} from '@material-ui/core';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import InputLabel from '@material-ui/core/InputLabel';
import MenuItem from '@material-ui/core/MenuItem';
import Select from '@material-ui/core/Select';
import Checkbox from '@material-ui/core/Checkbox';
import TextField from '@material-ui/core/TextField';

import css from "./styles.module.scss";
import people2 from './people2.jpg';
import people3 from './people3.jpg';
import people5 from './people5.jpg';

function getSteps() {
  return [
    'Формат',
    'Опыт работы',
    'Запрос 1|2',
    'Запрос 2|2',
    'Специалисты',
    // 'Оплата',
    // 'План занятий'
  ];
}

function getStepContent(stepIndex) {
  const formats = [
    {
      id: "1",
      name: "лично",
    },
    {
      id: "2",
      name: "онлайн",
    },
    {
      id: "3",
      name: "оба варианта подходят",
    },
  ]
  const [format, setFormat] = useState('1');
  const handleChangeFormat = (event) => {
    setFormat(event.target.value);
  };

  const cities = [
    {
      id: 1,
      name: "city1",
    },
    {
      id: 2,
      name: "city2",
    },
    {
      id: 3,
      name: "city3",
    }
  ];
  const [city, setCity] = useState("");
  const handleChangeCity = (event) => {
    setCity(event.target.value);
  };

  const industries = [
    {
      id: 1,
      name: "industry1",
    },
    {
      id: 2,
      name: "industry2",
    },
    {
      id: 3,
      name: "industry3",
    }
  ];
  const [industry, setIndustry] = useState("");
  const handleChangeIndustry = (event) => {
    setIndustry(event.target.value);
  };

  const specializations = [
    {
      id: 1,
      name: "specialization1",
    },
    {
      id: 2,
      name: "specialization2",
    },
    {
      id: 3,
      name: "specialization3",
    }
  ];
  const [specialization, setSpecialization] = useState("");
  const handleChangeSpecialization = (event) => {
    setSpecialization(event.target.value);
  };

  const [mark, setMark] = useState("");
  const handleChangeMark = (event) => {
    if (event.target.name == 'mark') {
      setMark(event.target.checked);
    }
  };

  const experienceMarks = [
    {
      id: "1",
      name: "менее 1 года",
    },
    {
      id: "2",
      name: "от 1 года до 3 лет",
    },
    {
      id: "3",
      name: "от 3 лет до 6 лет",
    },
    {
      id: "4",
      name: "более 6 лет",
    }
  ];
  const [experienceMark, setExperienceMark] = useState("1");
  const handleChangeExperienceMark = (event) => {
    setExperienceMark(event.target.value);
  };

  const positions = [
    {
      id: "1",
      name: "Стажёр",
    },
    {
      id: "2",
      name: "Специалист",
    },
    {
      id: "3",
      name: "Менеджер",
    },
    {
      id: "4",
      name: "Топ - менеджер",
    }
  ];
  const [position, setPosition] = useState("1");
  const handleChangePosition = (event) => {
    setPosition(event.target.value);
  };

  const messengers = [
    {
      id: "1",
      name: "Telegram",
    },
    {
      id: "2",
      name: "WhatsApp",
    },
  ];
  const [messenger, setMessenger] = useState("1");
  const handleChangeMessenger = (event) => {
    setMessenger(event.target.value);
  };

  const [isApproval, setIsApproval] = useState(1);
  const handleChangeIsApproval = (event) => {
    if (event.target.name == 'isApproval') {
      setIsApproval(event.target.checked);
    }
  };

  const peoples = [
    {
      key: 5,
      imgSrc: people5,
      name: "Сергей С.",
      position: "Стратегический консультант",
      experience: "13 лет",
      specialization: "Карьерный коуч",
    },
    {
      key: 2,
      imgSrc: people2,
      name: "Вера О.",
      position: "HR-менеджер",
      experience: "8 лет",
      specialization: "Карьерный коуч",
    },
    {
      key: 3,
      imgSrc: people3,
      name: "Евгения С.",
      position: "Рекрутер",
      experience: "9 лет",
      specialization: "Карьерный консультант в производстве",
    },
  ];

  switch (stepIndex) {
    case 0:
      return (
        <Container maxWidth="md" style={{ padding: "50px 0" }}>
          <Grid container spacing={3} alignItems="center" justify="center">
            <Grid item xs={12} sm={8}>
              <FormControl component="fieldset" fullWidth>
                <FormLabel>Выберите в каком формате вам удобнее заниматься</FormLabel>
                <RadioGroup aria-label="format" name="format" value={format} onChange={handleChangeFormat}>
                  {formats.map((item) => (
                    <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                      {item.name}
                    </FormControlLabel>
                  ))}
                </RadioGroup>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="city-label">В каком городе вы живете?</InputLabel>
                <Select
                  id="city"
                  labelId="city-label"
                  value={city}
                  onChange={handleChangeCity}
                  fullWidth
                  required
                >
                  {cities.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
          </Grid>
        </Container>
      );
    case 1:
      return (
        <Container maxWidth="md" style={{ padding: "50px 0" }}>
          <Grid container spacing={3} alignItems="center" justify="center">
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="industry-label">Выберите отрасль, в которой вы работаете:</InputLabel>
                <Select
                  labelId="industry-label"
                  value={industry}
                  onChange={handleChangeIndustry}
                  fullWidth
                  required
                >
                  {industries.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="specialization-label">Выберите вашу специализацию:</InputLabel>
                <Select
                  id="specialization"
                  labelId="specialization-label"
                  value={specialization}
                  onChange={handleChangeSpecialization}
                  fullWidth
                  required
                >
                  {specializations.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={mark}
                    onChange={handleChangeMark}
                    name="mark"
                    color="secondary"
                  />
                }
                label="Подобрать наставника, который знаком с моей отраслью и профессией:"
                labelPlacement="start"
              />
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl component="fieldset" fullWidth>
                <FormLabel>Укажите ваш стаж работы:</FormLabel>
                <RadioGroup aria-label="experienceMark" name="experienceMark" value={experienceMark} onChange={handleChangeExperienceMark}>
                  {experienceMarks.map((item) => (
                    <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                      {item.name}
                    </FormControlLabel>
                  ))}
                </RadioGroup>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl component="fieldset" fullWidth>
                <FormLabel>Укажите ваш уровень позиции:</FormLabel>
                <RadioGroup aria-label="position" name="position" value={position} onChange={handleChangePosition}>
                  {positions.map((item) => (
                    <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                      {item.name}
                    </FormControlLabel>
                  ))}
                </RadioGroup>
              </FormControl>
            </Grid>
          </Grid>
        </Container>
      );
    case 2:
      return (
        <Container maxWidth="md" style={{ padding: "50px 0" }}>
          <Grid container spacing={3} alignItems="center" justify="center">
            <Typography variant="h5" component="h2">Опишите свою проблему с помощью тегов:</Typography>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="less-interviews">У меня мало собеседований:</InputLabel>
                <Select
                  id="11"
                  labelId="less-interviews"
                  value={specialization}
                  onChange={handleChangeSpecialization}
                  fullWidth
                  required
                >
                  {specializations.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="rejected-label">Мне отказывают после собеседования:</InputLabel>
                <Select
                  labelId="rejected-label"
                  value={specialization}
                  onChange={handleChangeSpecialization}
                  fullWidth
                  required
                >
                  {specializations.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="poor-conditions-label">Предлагают не подходяие условия:</InputLabel>
                <Select
                  labelId="poor-conditions-label"
                  value={specialization}
                  onChange={handleChangeSpecialization}
                  fullWidth
                  required
                >
                  {specializations.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="development-label">Развитие в компании, стратегия развития:</InputLabel>
                <Select
                  labelId="development-label"
                  value={specialization}
                  onChange={handleChangeSpecialization}
                  fullWidth
                  required
                >
                  {specializations.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <InputLabel id="new-career-label">Развитие новой карьеры:</InputLabel>
                <Select
                  labelId="new-career-label"
                  value={specialization}
                  onChange={handleChangeSpecialization}
                  fullWidth
                  required
                >
                  {specializations.map((item) => (
                    <MenuItem key={item.id} value={item.id}>
                      {item.name}
                    </MenuItem>
                  ))}
                </Select>
              </FormControl>
            </Grid>
          </Grid>
        </Container>
      );
    case 3:
      return (
        <Container maxWidth="md" style={{ padding: "50px 0" }}>
          <Grid container spacing={3} alignItems="center" justify="center">
            <Typography variant="h5" component="h2">
              Чтобы мы могли вам рекомендовать специалистов, заполните информацию о себе:
            </Typography>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <TextField id="name" label="Как вас зовут:" />
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <TextField id="email" label="Укажите E-mail:" />
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <TextField id="phone" label="Укажите телефон:" />
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <TextField id="phone" label="Пароль:" />
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl fullWidth>
                <TextField id="phone" label="Повторите пароль:" />
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControl component="fieldset" fullWidth>
                <FormLabel>Через какой мессенджер вам удобнее общаться:</FormLabel>
                <RadioGroup aria-label="messenger" name="messenger" value={messenger} onChange={handleChangeMessenger}>
                  {messengers.map((item) => (
                    <FormControlLabel key={item.id} value={item.id} control={<Radio />} label={item.name}>
                      {item.name}
                    </FormControlLabel>
                  ))}
                </RadioGroup>
              </FormControl>
            </Grid>
            <Grid item xs={12} sm={8}>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={isApproval}
                    onChange={handleChangeIsApproval}
                    name="isApproval"
                    color="secondary"
                  />
                }
                label="Я согласен с политикой(линк) обработки персональных данных:"
                labelPlacement="start"
              />
            </Grid>
          </Grid>
        </Container>
      );
    case 4:
      return (
        <Container maxWidth="md" style={{ padding: "50px 0" }}>
          <Grid container spacing={3} alignItems="center" justify="center">
            <Typography variant="h5" component="h2">Выберите подходящего специалиста</Typography>
            <Typography variant="h6" component="h3">Мы выбрали наиболее подходящих специалистов на основе вашего запроса</Typography>
            <Grid container justify="center" className={css.wrapContainer}>
              {peoples.map((item) => {
                return (
                  <Grid key={item.key} item xs={12} md={6} lg={4}>
                    <div className={css.itemWrapper}>
                      <Card className={css.card}>
                        <CardMedia
                          className={css.cardMedia}
                          image={item.imgSrc}
                          title={item.name}
                        />
                        <CardContent>
                          <Typography
                            variant="body1"
                            color="textSecondary"
                            component="p"
                          >
                            {item.name}
                          </Typography>
                          <Typography
                            variant="body1"
                            color="textSecondary"
                            component="p"
                          >
                            {item.position}, {item.experience}
                          </Typography>
                          <Typography
                            variant="body1"
                            color="textSecondary"
                            component="p"
                          >
                            {item.specialization}
                          </Typography>
                        </CardContent>
                      </Card>
                    </div>
                  </Grid>
                );
              })}
            </Grid>
          </Grid>
        </Container>
      );
    case 5:
      return (
        <Container maxWidth="md" style={{ padding: "50px 0" }}>
          <Grid container spacing={3} alignItems="center" justify="center">
            <p>страница оплаты</p>
          </Grid>
        </Container>
      );
    case 6:
      return (
        <Container maxWidth="md" style={{ padding: "50px 0" }}>
          <Grid container spacing={3} alignItems="center" justify="center">
            <p>страница с планом занятий</p>
          </Grid>
        </Container>
      );
    default:
      return 'Unknown stepIndex';
  }
}

const RequestForm = () => {
  const [activeStep, setActiveStep] = React.useState(0);
  const steps = getSteps();

  const handleNext = () => {
    setActiveStep((prevActiveStep) => prevActiveStep + 1);
  };

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1);
  };

  const handleReset = () => {
    setActiveStep(0);
  };

  return (
    <div>
      {activeStep !== steps.length ? (
        <div>
          <Typography>{getStepContent(activeStep)}</Typography>
        </div>
      ) : (
        <React.Fragment>
          Форма оплаты...
        </React.Fragment>
      )}
      <div>
        {activeStep === steps.length ? (
          <div>
            <Typography>Форма заполнена</Typography>
            <Button onClick={handleReset}>Сбросить</Button>
          </div>
        ) : (
          <div>
            <div>
              <Button
                disabled={activeStep === 0}
                onClick={handleBack}
              >
                Назад
              </Button>
              <Button variant="contained" color="primary" onClick={handleNext}>
                {activeStep === steps.length - 1 ? 'Отправить' : 'Дальше'}
              </Button>
            </div>
          </div>
        )}
      </div>
      <Stepper activeStep={activeStep} alternativeLabel>
        {steps.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>

    </div>
  );
};

export default RequestForm;
