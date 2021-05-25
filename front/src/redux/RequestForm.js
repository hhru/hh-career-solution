const SET_REQUEST_FORM_ACTION = "SET_REQUEST_FORM_ACTION";

export function setRequestForm(data) {
  return {
    type: SET_REQUEST_FORM_ACTION,
    payload: data
  };
}

const defaultState = {
  consultationType: '',
  consultationTypeList: [],
  experience: '',
  experienceList: [],
  customerType: '',
  customerTypeList: [],
};

export default function requestForm(state = defaultState, { type, payload }) {
  switch (type) {
    case SET_REQUEST_FORM_ACTION:
      return { ...state, ...payload };
    default:
      return state;
  }
}
