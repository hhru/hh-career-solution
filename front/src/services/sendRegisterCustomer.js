

const sendRegisterCustomer = (data) => {
  var formBody = [];
  for (var property in data) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(data[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");

  return fetch(`http://localhost:9999/account/signup`, {
    method: 'POST',
    credentials: 'include',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  }).then(response => {
    if (response.status == 204) {
      const result = {
        code: 0,
        message: 'success'
      }
      console.log(result);
      return result;
    } else {
      const result = response.json();
      console.log(result);
      return result;
    }
  })
    .then(data => console.log(data))
    .catch((error) => console.log('err', error));
}

export default sendRegisterCustomer;
