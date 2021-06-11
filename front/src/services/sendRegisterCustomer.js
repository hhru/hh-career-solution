

const sendRegisterCustomer = (data) => {
  return function (dispatch, getState) {
    var formBody = [];
    for (var property in data) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(data[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    return fetch(`http://localhost:9999/account/signup`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
      },
      body: formBody
    }).then(response => {
      if (response.status == 204) {
        return {
          code: 0,
          message: 'success'
        };
      } else {
        return response.json();
      }
    }).then(data => {
      console.log(data);
    }).catch((error) => console.log('err', error));
  }
}

export default sendRegisterCustomer;
