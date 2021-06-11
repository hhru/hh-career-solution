import { setRequestForm } from "src/redux/RequestForm";

export default function fetchConsultationType() {
  return function (dispatch, getState) {
    const data = [
      {
        id: "OFFLINE",
        name: "лично",
      },
      {
        id: "ONLINE",
        name: "онлайн",
      },
      {
        id: "ALL",
        name: "оба варианта подходят",
      },
    ];
    dispatch(setRequestForm({ consultationTypeList: data }));
  };
}
