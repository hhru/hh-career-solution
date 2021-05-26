const SET_SPECIALIZATIONS_ACTION = "SET_SPECIALIZATIONS_ACTION";
const SET_INDUSTRY_ACTION = "SET_INDUSTRY_ACTION";
const SET_SPECIALIZATION_ACTION = "SET_SPECIALIZATION_ACTION";

export function setSpecializations(data) {
  return {
    type: SET_SPECIALIZATIONS_ACTION,
    payload: data
  };
}

export function setIndustryId(data) {
  return {
    type: SET_INDUSTRY_ACTION,
    payload: data
  };
}

export function setSpecializationId(data) {
  return {
    type: SET_SPECIALIZATION_ACTION,
    payload: data
  };
}

const defaultSpecialization = {
  industries: [],
  industryId: '',
  specializations: [],
  specializationId: '',
};

export default function specialization(state = defaultSpecialization, { type, payload }) {
  switch (type) {
    case SET_SPECIALIZATIONS_ACTION:
      return { ...state, ...{ industries: payload } };
    case SET_INDUSTRY_ACTION:
      const industry = state.industries.filter((item) => {
        return item.id == payload
      }).pop();
      const specializations = industry.specializations;
      return { ...state, ...{ industryId: payload, specializationId: '', specializations: specializations } };
    case SET_SPECIALIZATION_ACTION:
      return { ...state, ...{ specializationId: payload } };
    default:
      return state;
  }
}
