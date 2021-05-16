import { setRequestForm } from "src/redux/RequestForm";

export default function fetchConsultationType() {
  return function (dispatch, getState) {
    const data = [
      {
        id: "1",
        name: "лично",
      },
      {
        id: "2",
        name: "онлайн",
      },
      {
        id: "3",
        name: "оба варианта подходят",
      },
    ];
    dispatch(setRequestForm({ consultationTypeList: data }));
  };
}
