import React from "react";

import css from "./styles.module.scss";

import {
  Typography, Container
} from '@material-ui/core';

const renderList = (id, list) => {
  return (
    <ol key={id} className={css.list}>
      {list.length > 0 && list.map(item => renderItem(item))}
    </ol>
  );
}

const renderItem = (item) => {
  return (
    <li key={item.id} className={css.listItem}>
      <Typography className={css.listItemContent}>{item.text}</Typography>
      {item.items.length > 0 && renderList(item.id, item.items)}
    </li>
  );
}

const Policy = () => {
  const siteUrl = "http://liftcareer.ws/";
  const siteUrlPolicy = "http://liftcareer.ws/politika";
  const operatorFullName = "Мазикин Егор Александрович";
  const feedbackEmail = "mazikin.e.a@yandex.ru";
  const items = [
    {
      id: "1",
      text: `Общие положения`,
      items: [
        {
          id: "1.1",
          text: `Настоящая политика обработки персональных данных составлена в соответствии с требованиями Федерального закона от 27.07.2006.№152 - ФЗ «О персональных данных» и определяет порядок обработки персональных данных и меры по обеспечению безопасности персональных данных, предпринимаемые ${operatorFullName}(далее – Оператор).`,
          items: []
        },
        {
          id: "1.2",
          text: "Оператор ставит своей важнейшей целью и условием осуществления своей деятельности соблюдение прав и свобод человека и гражданина при обработке его персональных данных, в том числе защиты прав на неприкосновенность частной жизни, личную и семейную тайну.",
          items: [],
        },
        {
          id: "1.3",
          text: `Настоящая политика Оператора в отношении обработки персональных данных(далее – Политика) применяется ко всей информации, которую Оператор может получить о посетителях веб - сайта ${siteUrl}.`,
          items: [],
        }
      ]
    },
    {
      id: "2",
      text: `Основные понятия, используемые в Политике`,
      items: [
        {
          id: "2.1",
          text: "Автоматизированная обработка персональных данных – обработка персональных данных с помощью средств вычислительной техники;",
          items: [],
        },
        {
          id: "2.2",
          text: "Блокирование персональных данных – временное прекращение обработки персональных данных(за исключением случаев, если обработка необходима для уточнения персональных данных);",
          items: [],
        },
        {
          id: "2.3",
          text: `Веб - сайт – совокупность графических и информационных материалов, а также программ для ЭВМ и баз данных, обеспечивающих их доступность в сети интернет по сетевому адресу ${siteUrl};`,
          items: [],
        },
        {
          id: "2.4",
          text: "Информационная система персональных данных — совокупность содержащихся в базах данных персональных данных, и обеспечивающих их обработку информационных технологий и технических средств;",
          items: [],
        },
        {
          id: "2.5",
          text: "Обезличивание персональных данных — действия, в результате которых невозможно определить без использования дополнительной информации принадлежность персональных данных конкретному Пользователю или иному субъекту персональных данных;",
          items: [],
        },
        {
          id: "2.6",
          text: "Обработка персональных данных – любое действие(операция) или совокупность действий(операций), совершаемых с использованием средств автоматизации или без использования таких средств с персональными данными, включая сбор, запись, систематизацию, накопление, хранение, уточнение(обновление, изменение), извлечение, использование, передачу(распространение, предоставление, доступ), обезличивание, блокирование, удаление, уничтожение персональных данных;",
          items: [],
        },
        {
          id: "2.7",
          text: "Оператор – государственный орган, муниципальный орган, юридическое или физическое лицо, самостоятельно или совместно с другими лицами организующие и(или) осуществляющие обработку персональных данных, а также определяющие цели обработки персональных данных, состав персональных данных, подлежащих обработке, действия(операции), совершаемые с персональными данными;",
          items: [],
        },
        {
          id: "2.8",
          text: `Персональные данные – любая информация, относящаяся прямо или косвенно к определенному или определяемому Пользователю веб - сайта ${siteUrl};`,
          items: [],
        },
        {
          id: "2.9",
          text: `Пользователь – любой посетитель веб - сайта ${siteUrl};`,
          items: [],
        },
        {
          id: "2.10",
          text: "Предоставление персональных данных – действия, направленные на раскрытие персональных данных определенному лицу или определенному кругу лиц;",
          items: [],
        },
        {
          id: "2.11",
          text: "Распространение персональных данных – любые действия, направленные на раскрытие персональных данных неопределенному кругу лиц(передача персональных данных) или на ознакомление с персональными данными неограниченного круга лиц, в том числе обнародование персональных данных в средствах массовой информации, размещение в информационно - телекоммуникационных сетях или предоставление доступа к персональным данным каким - либо иным способом;",
          items: [],
        },
        {
          id: "2.12",
          text: "Трансграничная передача персональных данных – передача персональных данных на территорию иностранного государства органу власти иностранного государства, иностранному физическому или иностранному юридическому лицу;",
          items: [],
        },
        {
          id: "2.13",
          text: "Уничтожение персональных данных – любые действия, в результате которых персональные данные уничтожаются безвозвратно с невозможностью дальнейшего восстановления содержания персональных данных в информационной системе персональных данных и(или) уничтожаются материальные носители персональных данных.",
          items: [],
        },
      ]
    },
    {
      id: "3",
      text: `Оператор может обрабатывать следующие персональные данные Пользователя`,
      items: [
        {
          id: "3.1",
          text: "Фамилия, имя, отчество;",
          items: [],
        },
        {
          id: "3.2",
          text: "Электронный адрес;",
          items: [],
        },
        {
          id: "3.3",
          text: "Номера телефонов;",
          items: [],
        },
        {
          id: "3.4",
          text: "Сведения об образовании, профессии, специальности и квалификации, реквизиты документов об образовании;",
          items: [],
        },
        {
          id: "3.5",
          text: "Сведения о занимаемых ранее должностях и стаже работы, воинской обязанности, воинском учете;",
          items: [],
        },
        {
          id: "3.6",
          text: "Также на сайте происходит сбор и обработка обезличенных данных о посетителях(в т.ч.файлов «cookie») с помощью сервисов интернет - статистики(Яндекс Метрика и Гугл Аналитика и других).",
          items: [],
        },
        {
          id: "3.7",
          text: "Вышеперечисленные данные далее по тексту Политики объединены общим понятием Персональные данные.",
          items: [],
        },
      ]
    },
    {
      id: "4",
      text: `Цели обработки персональных данных`,
      items: [
        {
          id: "4.1",
          text: "Цель обработки персональных данных Пользователя — информирование Пользователя посредством отправки электронных писем; предоставление доступа Пользователю к сервисам, информации и / или материалам, содержащимся на веб - сайте.",
          items: [],
        },
        {
          id: "4.2",
          text: "Также Оператор имеет право направлять Пользователю уведомления о новых продуктах и услугах, специальных предложениях и различных событиях.Пользователь всегда может отказаться от получения информационных сообщений, направив Оператору письмо на адрес электронной почты mazikin.e.a@yandex.ru с пометкой «Отказ от уведомлений о новых продуктах и услугах и специальных предложениях».",
          items: [],
        },
        {
          id: "4.3",
          text: "Обезличенные данные Пользователей, собираемые с помощью сервисов интернет - статистики, служат для сбора информации о действиях Пользователей на сайте, улучшения качества сайта и его содержания.",
          items: [],
        },
      ]
    },
    {
      id: "5",
      text: `Правовые основания обработки персональных данных`,
      items: [
        {
          id: "5.1",
          text: `Оператор обрабатывает персональные данные Пользователя только в случае их заполнения и / или отправки Пользователем самостоятельно через специальные формы, расположенные на сайте ${siteUrl}. Заполняя соответствующие формы и/или отправляя свои персональные данные Оператору, Пользователь выражает свое согласие с данной Политикой.`,
          items: [],
        },
        {
          id: "5.2",
          text: "Оператор обрабатывает обезличенные данные о Пользователе в случае, если это разрешено в настройках браузера Пользователя(включено сохранение файлов «cookie» и использование технологии JavaScript).",
          items: [],
        }
      ]
    },
    {
      id: "6",
      text: `Порядок сбора, хранения, передачи и других видов обработки персональных данных Безопасность персональных данных, которые обрабатываются Оператором, обеспечивается путем реализации правовых, организационных и технических мер, необходимых для выполнения в полном объеме требований действующего законодательства в области защиты персональных данных.`,
      items: [
        {
          id: "6.1",
          text: `Оператор обеспечивает сохранность персональных данных и принимает все возможные меры, исключающие доступ к персональным данным неуполномоченных лиц.`,
          items: [],
        },
        {
          id: "6.2",
          text: "Персональные данные Пользователя никогда, ни при каких условиях не будут переданы третьим лицам, за исключением случаев, связанных с исполнением действующего законодательства.",
          items: [],
        },
        {
          id: "6.3",
          text: "В случае выявления неточностей в персональных данных, Пользователь может актуализировать их самостоятельно, путем направления Оператору уведомление на адрес электронной почты Оператора mazikin.e.a@yandex.ru с пометкой «Актуализация персональных данных».",
          items: [],
        },
        {
          id: "6.4",
          text: "Срок обработки персональных данных является неограниченным.Пользователь может в любой момент отозвать свое согласие на обработку персональных данных, направив Оператору уведомление посредством электронной почты на электронный адрес Оператора mazikin.e.a@yandex.ru с пометкой «Отзыв согласия на обработку персональных данных».",
          items: [],
        },
      ]
    },
    {
      id: "7",
      text: `Трансграничная передача персональных данных`,
      items: [
        {
          id: "7.1",
          text: `Оператор до начала осуществления трансграничной передачи персональных данных обязан убедиться в том, что иностранным государством, на территорию которого предполагается осуществлять передачу персональных данных, обеспечивается надежная защита прав субъектов персональных данных.`,
          items: [],
        },
        {
          id: "7.2",
          text: "Трансграничная передача персональных данных на территории иностранных государств, не отвечающих вышеуказанным требованиям, может осуществляться только в случае наличия согласия в письменной форме субъекта персональных данных на трансграничную передачу его персональных данных и / или исполнения договора, стороной которого является субъект персональных данных.",
          items: [],
        },
      ]
    },
    {
      id: "8",
      text: `Заключительные положения`,
      items: [
        {
          id: "8.1",
          text: `Пользователь может получить любые разъяснения по интересующим вопросам, касающимся обработки его персональных данных, обратившись к Оператору с помощью электронной почты ${feedbackEmail}.`,
          items: [],
        },
        {
          id: "8.2",
          text: "В данном документе будут отражены любые изменения политики обработки персональных данных Оператором. Политика действует бессрочно до замены ее новой версией.",
          items: [],
        },
        {
          id: "8.3",
          text: `Актуальная версия Политики в свободном доступе расположена в сети Интернет по адресу ${siteUrlPolicy}.`,
          items: [],
        }
      ]
    },
  ];

  return (
    <Container>
      {renderList("root", items)}
    </Container>
  );
}

export default Policy