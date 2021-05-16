import { setRequestForm } from "src/redux/RequestForm";

export default function fetchExperienceList() {
  return function (dispatch, getState) {
    const data = [
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
    dispatch(setRequestForm({ experienceList: data }));

    // return fetch(`https://api.hh.ru/dictionaries`)
    //   .then(response => response.json())
    //   .then(data => {
    //     if (Array.isArray(data.experience)) {
    //       dispatch(setRequestForm({ experienceList: data.experience }));
    //     } else {
    //       console.log('invalid data', data);
    //     }
    //   })
    //   .catch((error) => console.error(error));
  };
}
