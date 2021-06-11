import { setTags } from "src/redux/Tags";

export default function fetchTags() {
  return function (dispatch, getState) {
    const data = {
      lessInterviews: [
        {
          id: "1",
          name: "Давно не искал(а) работу, не знаю с чего начать",
        },
        {
          id: "2",
          name: "Мало просмотров резюме",
        },
        {
          id: "3",
          name: "Мне часто не отвечают на отклик",
        },
        {
          id: "4",
          name: "Меня зовут на собеседования не те компании",
        },
        {
          id: "5",
          name: "Меня зовут на собеседования не на те позиции",
        },
        {
          id: "6",
          name: "Я не могу найти подходящие вакансии",
        },
      ],
      qualifyingStages: [
        {
          id: "1",
          name: "Не знаю о чем спрашивать на собеседовании",
        },
        {
          id: "2",
          name: "Не знаю как о себе рассказать на собеседовании",
        },
        {
          id: "3",
          name: "Я хочу потренироваться решать кейсы, брейнтизеры, тесты",
        },
        {
          id: "4",
          name: "Я не знаю, как договариваться о зарплате",
        },
      ],
      refuse: [
        {
          id: "1",
          name: "refuse1",
        },
        {
          id: "2",
          name: "refuse2",
        },
        {
          id: "3",
          name: "refuse3",
        },
      ],
      badConditions: [
        {
          id: "1",
          name: "Не знаю соответствуют ли мои навыки рынку",
        },
        {
          id: "2",
          name: "Предложения по зарплате меня не устраивают",
        },
        {
          id: "3",
          name: "Предложения по позиции меня не устраивают",
        },
        {
          id: "4",
          name: "Я не знаю как сравнить несколько предложений о работе",
        },
      ],
      development: [
        {
          id: "1",
          name: "development1",
        },
        {
          id: "2",
          name: "development2",
        },
        {
          id: "3",
          name: "development3",
        },
      ],
      newCareer: [
        {
          id: "1",
          name: "newCareer1",
        },
        {
          id: "2",
          name: "newCareer2",
        },
        {
          id: "3",
          name: "newCareer3",
        },
      ],
    };
    dispatch(setTags(data));
  };
}
