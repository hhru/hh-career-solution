const SET_AREA_ACTION = "SET_AREA_ACTION";
const SET_COUNTRY_ACTION = "SET_COUNTRY_ACTION";
const SET_REGION_ACTION = "SET_REGION_ACTION";
const SET_CITY_ACTION = "SET_CITY_ACTION";

export function setArea(data) {
  return {
    type: SET_AREA_ACTION,
    payload: data
  };
}

export function setCountryId(data) {
  return {
    type: SET_COUNTRY_ACTION,
    payload: data
  };
}

export function setRegionId(data) {
  return {
    type: SET_REGION_ACTION,
    payload: data
  };
}

export function setCityId(data) {
  return {
    type: SET_CITY_ACTION,
    payload: data
  };
}

const defaultArea = {
  areaId: null,
  countries: [],
  countryId: '',
  regions: [],
  regionId: '',
  cities: [],
  cityId: '',
};

export default function area(state = defaultArea, { type, payload }) {
  let areaId = null;
  switch (type) {
    case SET_AREA_ACTION:
      return { ...state, countries: payload };
    case SET_COUNTRY_ACTION:
      const country = state.countries.find((item) => {
        return item.id == payload;
      });
      const regions = country.areas;
      if (regions.length == 0) {
        areaId = payload;
      }
      return { ...state, countryId: payload, regionId: '', cityId: '', regions: regions, cities: [], areaId: areaId };
    case SET_REGION_ACTION:
      const region = state.regions.find((item) => {
        return item.id == payload
      });
      const cities = region.areas;
      if (cities.length == 0) {
        areaId = payload;
      }
      return { ...state, regionId: payload, cityId: '', cities: cities, areaId: areaId };
    case SET_CITY_ACTION:
      return { ...state, cityId: payload, areaId: payload };
    default:
      return state;
  }
}
