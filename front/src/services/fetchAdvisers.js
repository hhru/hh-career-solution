import { setAdvisers } from "src/redux/Advisers";

export default function fetchAdvisers(problemId) {
  return function (dispatch, getState) {
    return fetch(`http://localhost:9999/customers/problems/${problemId}/matches`)
      .then(response => response.json())
      .then(data => {
        console.log(data);
        if (Array.isArray(data.items)) {
          dispatch(setAdvisers({ list: data.items }));
        } else {
          console.log('invalid data', data);
        }
      })
      .catch((error) => console.error(error));
  };
}
