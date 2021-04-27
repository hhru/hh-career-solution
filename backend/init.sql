CREATE TABLE account
(
  id              serial      primary key,
  username        text        not null,
  password_hash   text        not null
);

CREATE TYPE adviserConsultationType AS ENUM('offline', 'online', 'all');

CREATE TYPE adviserExperienceType AS ENUM('noExperience', 'between1And3', 'between3And6', 'moreThan6');

CREATE TYPE adviserCareerType AS ENUM('consultation', 'coaching', 'all');

CREATE TYPE adviserCustomerType AS ENUM('noExperience', 'specialistAndExperts', 'middleManagement', 'topManagement');

CREATE TABLE adviser
(
  id              SERIAL PRIMARY KEY,
  name            VARCHAR   NOT NULL,
  surname         VARCHAR   NOT NULL,
  consultation    adviserConsultationType,
  experience      adviserExperienceType,
  career_practice adviserCareerType,
  customer_type   adviserCustomerType
);
