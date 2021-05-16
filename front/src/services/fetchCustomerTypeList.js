import { setRequestForm } from "src/redux/RequestForm";

export default function fetchCustomerTypeList() {
  return function (dispatch, getState) {
    const data = [
      {
        id: "NO_EXPERIENCE",
        name: "Стажёр",
      },
      {
        id: "SPECIALIST_AND_EXPERTS",
        name: "Специалист",
      },
      {
        id: "MIDDLE_MANAGEMENT",
        name: "Менеджер",
      },
      {
        id: "TOP_MANAGEMENT",
        name: "Топ - менеджер",
      }
    ];
    dispatch(setRequestForm({ customerTypeList: data }));
  };
}
