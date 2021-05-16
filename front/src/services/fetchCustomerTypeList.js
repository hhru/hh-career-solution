import { setRequestForm } from "src/redux/RequestForm";

export default function fetchCustomerTypeList() {
  return function (dispatch, getState) {
    const data = [
      {
        id: "1",
        name: "Стажёр",
      },
      {
        id: "2",
        name: "Специалист",
      },
      {
        id: "3",
        name: "Менеджер",
      },
      {
        id: "4",
        name: "Топ - менеджер",
      }
    ];
    dispatch(setRequestForm({ customerTypeList: data }));
  };
}
