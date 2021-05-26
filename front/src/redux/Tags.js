const SET_TAGS_ACTION = "SET_TAGS_ACTION";

export function setTags(data) {
  return {
    type: SET_TAGS_ACTION,
    payload: data
  };
}

const defaultState = {
  lessInterviews: [],
  lessInterviewIds: [],
  qualifyingStages: [],
  qualifyingStageIds: [],
  refuse: [],
  refuseIds: [],
  badConditions: [],
  badConditionIds: [],
  development: [],
  developmentIds: [],
  newCareer: [],
  newCareerIds: [],
};

export default function tags(state = defaultState, { type, payload }) {
  switch (type) {
    case SET_TAGS_ACTION:
      return { ...state, ...payload };
    default:
      return state;
  }
}
