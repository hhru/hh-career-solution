const SET_AUTH_ACTION = "SET_AUTH_ACTION";

export function setAuth(data) {
  return {
    type: SET_AUTH_ACTION,
    payload: data
  };
}

function getHomeRoute(isAdviser, isCustomer) {
  if (isAdviser) {
    return '/adviser/cabinet';
  } else if (isCustomer) {
    return '/customer/cabinet';
  } else {
    return '/';
  }
}

const defaultState = {
  isAuthenticated: false,
  isCustomer: false,
  isAdviser: false,
  homeRoute: "/",
};

export default function auth(state = defaultState, { type, payload }) {
  switch (type) {
    case SET_AUTH_ACTION:
      const preResult = { ...state, ...payload };
      return { ...preResult, homeRoute: getHomeRoute(preResult.isAdviser, preResult.isCustomer) };
    default:
      return state;
  }
}
