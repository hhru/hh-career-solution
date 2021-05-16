import { combineReducers, createStore, applyMiddleware, compose } from "redux";
import customFunction from "./middlewares/customFunction";
import area from "./Area";
import requestForm from "./RequestForm";
import specialization from "./Specialization";
import tags from "./Tags";
import registerCustomerForm from "./RegisterCustomerForm";

const composeEnhancers =
  (typeof window !== "undefined" &&
    window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__) ||
  compose;

const reducer = combineReducers({
  area,
  requestForm,
  specialization,
  tags,
  registerCustomerForm
});

export default createStore(
  reducer,
  applyMiddleware(customFunction)
);
