import { setSpecializations } from "src/redux/Specialization";

export default function fetchSpecializations() {
  return function (dispatch, getState) {
    return fetch(`https://api.hh.ru/specializations`)
      .then(response => response.json())
      .then(data => {
        if (Array.isArray(data)) {
          dispatch(setSpecializations(data));
        } else {
          console.log('invalid data', data);
        }
      })
      .catch((error) => console.error(error));
  };
}
