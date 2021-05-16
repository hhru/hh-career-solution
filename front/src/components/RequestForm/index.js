import React from "react";

import css from "./styles.module.scss";

const RequestForm = () => {
  return (
    <React.Fragment>
      Выберите в каком формате вам удобнее заниматься: лично/онлайн/оба варианта подходят
      В каком городе вы живете?
      --
      Выберите отрасль, в которой вы работаете: список
      Выберите вашу специализацию: список
      Подобрать наставника, который знаком с моей отраслью и профессией: флаг
      --
      Укажите ваш стаж работы: менее 1г/от 1г до 3 лет/от 3 лет до 6 лет/более 6 лет
      Укажите ваш уровень позиции: Стажёр/Специалист/Менеджер/Топ-менеджер
      ----
      Опишите свою проблему с помощью тегов:
      У меня мало собеседований: список
      Мне отказывают после собеседования: список
      Предлагают не подходяие условия: список
      Развитие в компании, стратегия развития: список
      Развитие новой карьеры: список
      ----
      Чтобы мы могли вам рекомендовать специалистов, заполните информацию о себе:
      Как вас зовут: Имя
      Укажите E-mail: email
      Укажите телефон: телефон (если международный то маска не подходит)
      Пароль: пароль
      Повторите пароль: пароль
      Через какой мессенджер вам удобнее общаться: телеграмм/ватсап
      Я согласен с политикой(линк) обработки персональных данных: флаг
      ----
      Выберите подходящего специалиста
      Мы выбрали наиболее подходящих специалистов на основе вашего запроса
      3 карточки специалистов
      ----
      страница оплаты
      ----
      страница с планом занятий
    </React.Fragment>
  );
};

export default RequestForm;