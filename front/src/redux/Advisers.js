const SET_ADVISERS_ACTION = "SET_ADVISERS_ACTION";

export function setAdvisers(data) {
  return {
    type: SET_ADVISERS_ACTION,
    payload: data
  };
}

const defaultState = {
  problemId: null,
  list: [],
};

export default function tags(state = defaultState, { type, payload }) {
  switch (type) {
    case SET_ADVISERS_ACTION:
      return { ...state, ...payload };
    default:
      return state;
  }
}
