export const getSpecialization = (item) => {
  const map = {
    'CONSULTATION': 'Карьерный консультант',
    'COACHING': 'Карьерный коуч',
    'ALL': 'Карьерный коуч и консультант',
  };
  return map[item.careerPractice];
};

export const getExperience = (item) => {
  const map = {
    'NO_EXPERIENCE': 'опыт менее 1 года',
    'BETWEEN_1_AND_3': 'опыт от 1 года до 3 лет',
    'BETWEEN_3_AND_6': 'опыт от 3 лет до 6 лет',
    'MORE_THAN_6': 'опыт более 6 лет',
  };
  return map[item.experience];
};
