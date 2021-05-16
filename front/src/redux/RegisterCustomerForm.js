const SET_REGISTER_CUSTOMER_FORM_ACTION = "SET_REGISTER_CUSTOMER_FORM_ACTION";

export function setRegisterCustomerForm(data) {
  return {
    type: SET_REGISTER_CUSTOMER_FORM_ACTION,
    payload: data
  };
}

const defaultState = {
  fullName: '',
  email: '',
  phone: '',
  password: '',
  repeatPassword: '',
  messanger: '',
  messangerList: [
    {
      id: "1",
      name: "Telegram",
    },
    {
      id: "2",
      name: "WhatsApp",
    },
  ],
  isUserPolicyConfirm: false,
};

export default function registerCustomerForm(state = defaultState, { type, payload }) {
  switch (type) {
    case SET_REGISTER_CUSTOMER_FORM_ACTION:
      return { ...state, ...payload };
    default:
      return state;
  }
}
