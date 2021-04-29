CREATE TABLE account
(
  id              serial      primary key,
  username        text        not null,
  password_hash   text        not null
);

CREATE TYPE adviserConsultationType AS ENUM('OFFLINE', 'ONLINE', 'ALL');

CREATE TYPE adviserExperienceType AS ENUM('NO_EXPERIENCE', 'BETWEEN_1_AND_3', 'BETWEEN_3_AND_6', 'MORE_THAN_6');

CREATE TYPE adviserCareerType AS ENUM('CONSULTATION', 'COACHING', 'ALL');

CREATE TYPE adviserCustomerType AS ENUM('NO_EXPERIENCE', 'SPECIALIST_AND_EXPERTS', 'MIDDLE_MANAGEMENT', 'TOP_MANAGEMENT');

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
