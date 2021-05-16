import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  Typography, Container, Grid
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

import { setRegisterCustomerForm } from "src/redux/RegisterCustomerForm";

const RequestFormStepFour = () => {
  const dispatch = useDispatch();
  useEffect(() => {
  }, []);

  const registerCustomerForm = useSelector(({ registerCustomerForm }) => registerCustomerForm);
  console.log(registerCustomerForm);

  const [showPassword, setShowPassword] = useState(false);
  const handleClickShowPassword = (event) => {
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
    <Container maxWidth="md" style={{ padding: "50px 10px" }}>
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
              <Typography>
                1. Общие положения Настоящая политика обработки персональных данных составлена в соответствии с требованиями Федерального закона от 27.07.2006. №152-ФЗ «О персональных данных» и определяет порядок обработки персональных данных и меры по обеспечению безопасности персональных данных, предпринимаемые Мазикин Егор Александрович (далее – Оператор).
                1.1. Оператор ставит своей важнейшей целью и условием осуществления своей деятельности соблюдение прав и свобод человека и гражданина при обработке его персональных данных, в том числе защиты прав на неприкосновенность частной жизни, личную и семейную тайну.
                1.2. Настоящая политика Оператора в отношении обработки персональных данных (далее – Политика) применяется ко всей информации, которую Оператор может получить о посетителях веб-сайта http://liftcareer.ws/.

                Основные понятия, используемые в Политике
                2.1. Автоматизированная обработка персональных данных – обработка персональных данных с помощью средств вычислительной техники;
                2.2. Блокирование персональных данных – временное прекращение обработки персональных данных (за исключением случаев, если обработка необходима для уточнения персональных данных);
                2.3. Веб-сайт – совокупность графических и информационных материалов, а также программ для ЭВМ и баз данных, обеспечивающих их доступность в сети интернет по сетевому адресу http://liftcareer.ws/;
                2.4. Информационная система персональных данных — совокупность содержащихся в базах данных персональных данных, и обеспечивающих их обработку информационных технологий и технических средств;
                2.5. Обезличивание персональных данных — действия, в результате которых невозможно определить без использования дополнительной информации принадлежность персональных данных конкретному Пользователю или иному субъекту персональных данных;
                2.6. Обработка персональных данных – любое действие (операция) или совокупность действий (операций), совершаемых с использованием средств автоматизации или без использования таких средств с персональными данными, включая сбор, запись, систематизацию, накопление, хранение, уточнение (обновление, изменение), извлечение, использование, передачу (распространение, предоставление, доступ), обезличивание, блокирование, удаление, уничтожение персональных данных;
                2.7. Оператор – государственный орган, муниципальный орган, юридическое или физическое лицо, самостоятельно или совместно с другими лицами организующие и (или) осуществляющие обработку персональных данных, а также определяющие цели обработки персональных данных, состав персональных данных, подлежащих обработке, действия (операции), совершаемые с персональными данными;
                2.8. Персональные данные – любая информация, относящаяся прямо или косвенно к определенному или определяемому Пользователю веб-сайта http://liftcareer.ws/;
                2.9. Пользователь – любой посетитель веб-сайта http://liftcareer.ws/;
                2.10. Предоставление персональных данных – действия, направленные на раскрытие персональных данных определенному лицу или определенному кругу лиц;
                2.11. Распространение персональных данных – любые действия, направленные на раскрытие персональных данных неопределенному кругу лиц (передача персональных данных) или на ознакомление с персональными данными неограниченного круга лиц, в том числе обнародование персональных данных в средствах массовой информации, размещение в информационно-телекоммуникационных сетях или предоставление доступа к персональным данным каким-либо иным способом;
                2.12. Трансграничная передача персональных данных – передача персональных данных на территорию иностранного государства органу власти иностранного государства, иностранному физическому или иностранному юридическому лицу;
                2.13. Уничтожение персональных данных – любые действия, в результате которых персональные данные уничтожаются безвозвратно с невозможностью дальнейшего восстановления содержания персональных данных в информационной системе персональных данных и (или) уничтожаются материальные носители персональных данных.

                Оператор может обрабатывать следующие персональные данные Пользователя
                3.1. Фамилия, имя, отчество;
                3.2. Электронный адрес;
                3.3. Номера телефонов;
                3.4. Сведения об образовании, профессии, специальности и квалификации, реквизиты документов об образовании;
                3.5. Сведения о занимаемых ранее должностях и стаже работы, воинской обязанности, воинском учете;
                3.6. Также на сайте происходит сбор и обработка обезличенных данных о посетителях (в т.ч. файлов «cookie») с помощью сервисов интернет-статистики (Яндекс Метрика и Гугл Аналитика и других).
                3.7. Вышеперечисленные данные далее по тексту Политики объединены общим понятием Персональные данные.

                Цели обработки персональных данных
                4.1. Цель обработки персональных данных Пользователя — информирование Пользователя посредством отправки электронных писем; предоставление доступа Пользователю к сервисам, информации и/или материалам, содержащимся на веб-сайте.
                4.2. Также Оператор имеет право направлять Пользователю уведомления о новых продуктах и услугах, специальных предложениях и различных событиях. Пользователь всегда может отказаться от получения информационных сообщений, направив Оператору письмо на адрес электронной почты mazikin.e.a@yandex.ru с пометкой «Отказ от уведомлений о новых продуктах и услугах и специальных предложениях».
                4.3. Обезличенные данные Пользователей, собираемые с помощью сервисов интернет-статистики, служат для сбора информации о действиях Пользователей на сайте, улучшения качества сайта и его содержания.

                Правовые основания обработки персональных данных
                5.1. Оператор обрабатывает персональные данные Пользователя только в случае их заполнения и/или отправки Пользователем самостоятельно через специальные формы, расположенные на сайте http://liftcareer.ws/. Заполняя соответствующие формы и/или отправляя свои персональные данные Оператору, Пользователь выражает свое согласие с данной Политикой.
                5.2. Оператор обрабатывает обезличенные данные о Пользователе в случае, если это разрешено в настройках браузера Пользователя (включено сохранение файлов «cookie» и использование технологии JavaScript).

                Порядок сбора, хранения, передачи и других видов обработки персональных данных Безопасность персональных данных, которые обрабатываются Оператором, обеспечивается путем реализации правовых, организационных и технических мер, необходимых для выполнения в полном объеме требований действующего законодательства в области защиты персональных данных.
                6.1. Оператор обеспечивает сохранность персональных данных и принимает все возможные меры, исключающие доступ к персональным данным неуполномоченных лиц.
                6.2. Персональные данные Пользователя никогда, ни при каких условиях не будут переданы третьим лицам, за исключением случаев, связанных с исполнением действующего законодательства.
                6.3. В случае выявления неточностей в персональных данных, Пользователь может актуализировать их самостоятельно, путем направления Оператору уведомление на адрес электронной почты Оператора mazikin.e.a@yandex.ru с пометкой «Актуализация персональных данных».
                6.4. Срок обработки персональных данных является неограниченным. Пользователь может в любой момент отозвать свое согласие на обработку персональных данных, направив Оператору уведомление посредством электронной почты на электронный адрес Оператора mazikin.e.a@yandex.ru с пометкой «Отзыв согласия на обработку персональных данных».

                Трансграничная передача персональных данных
                7.1. Оператор до начала осуществления трансграничной передачи персональных данных обязан убедиться в том, что иностранным государством, на территорию которого предполагается осуществлять передачу персональных данных, обеспечивается надежная защита прав субъектов персональных данных.
                7.2. Трансграничная передача персональных данных на территории иностранных государств, не отвечающих вышеуказанным требованиям, может осуществляться только в случае наличия согласия в письменной форме субъекта персональных данных на трансграничную передачу его персональных данных и/или исполнения договора, стороной которого является субъект персональных данных.

                Заключительные положения
                8.1. Пользователь может получить любые разъяснения по интересующим вопросам, касающимся обработки его персональных данных, обратившись к Оператору с помощью электронной почты mazikin.e.a@yandex.ru.
                8.2. В данном документе будут отражены любые изменения политики обработки персональных данных Оператором. Политика действует бессрочно до замены ее новой версией.
                8.3. Актуальная версия Политики в свободном доступе расположена в сети Интернет по адресу http://liftcareer.ws/politika.
              </Typography>
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
    </Container>
  );
}

export default RequestFormStepFour;
