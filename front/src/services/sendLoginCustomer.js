
function getCookie(name) {
  let matches = document.cookie.match(new RegExp(
    "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
  ));
  return matches ? decodeURIComponent(matches[1]) : undefined;
}

const sendRegisterCustomer = (data) => {
  var formBody = [];
  for (var property in data) {
    var encodedKey = encodeURIComponent(property);
    var encodedValue = encodeURIComponent(data[property]);
    formBody.push(encodedKey + "=" + encodedValue);
  }
  formBody = formBody.join("&");

  return fetch(`http://localhost:9999/account/login`, {
    method: 'POST',
    credentials: 'include',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    body: formBody
  }).then(response => {
    if (response.status == 401 || response.status == 403) {
      const result = {
        code: -1,
        message: `bad credential: ${response.status}`
      };
      console.log(result);
      return result;
    } else {
      const result = {
        code: 0,
        sessionId: getCookie('JSESSIONID')
      };
      console.log(result);
      return result;
    }
  })
    .then(data => console.log(data))
    .catch((error) => console.log('err', error));
}

export default sendRegisterCustomer;
