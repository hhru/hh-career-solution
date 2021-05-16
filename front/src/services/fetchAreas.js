import { setArea } from "src/redux/Area";

export default function fetchAreas() {
  return function (dispatch, getState) {
    return fetch(`https://api.hh.ru/areas`)
      .then(response => response.json())
      .then(data => {
        if (Array.isArray(data)) {
          dispatch(setArea(data));
        } else {
          console.log('invalid data', data);
        }
      })
      .catch((error) => console.error(error));
  };
}
