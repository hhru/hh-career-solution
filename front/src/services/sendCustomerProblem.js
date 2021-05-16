import fetchAdvisers from "./fetchAdvisers";

const sendCustomerProblem = (data) => {
  return function (dispatch, getState) {
    return fetch(`http://localhost:9999/customers/problems`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json;charset=UTF-8'
      },
      body: JSON.stringify(data)
    }).then(response => {
      if (response.status == 201) {
        return response.json();
      } else {
        throw new Error("Некорректный ответ");
      }
    }).then(data => {
      console.log(data);
      dispatch(fetchAdvisers(data.problemId));
    }).catch((error) => console.error('err', error))
  }
}

export default sendCustomerProblem;
