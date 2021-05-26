import { setRegisterCustomerForm } from "src/redux/RegisterCustomerForm";

export default function fetchMessangerList() {
  return function (dispatch, getState) {
    const data = [
      {
        id: "1",
        name: "Telegram",
      },
      {
        id: "2",
        name: "WhatsApp",
      },
    ];
    dispatch(setRegisterCustomerForm({ messangerList: data }));
  };
}
