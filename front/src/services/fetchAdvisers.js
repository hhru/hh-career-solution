import { setAdvisers } from "src/redux/Advisers";

export default function fetchAdvisers() {
  return function (dispatch, getState) {
    return fetch(`http://localhost:9999/advisers`, {
      
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        // if (Array.isArray(data.items)) {
        //   dispatch(setAdvisers(data.items));
        // } else {
        //   console.log('invalid data', data);
        // }
      })
      .catch((error) => console.error(error));
  };
}
