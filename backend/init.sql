CREATE TABLE area
(
  area_id     INTEGER PRIMARY KEY,
  name   VARCHAR(100) NOT NULL,
  area_parent INTEGER
);

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
  customer_type   adviserCustomerType,
  account_id INTEGER NOT NULL REFERENCES account(id),
  image_link TEXT,
  area_id INTEGER NOT NULL REFERENCES area(area_id),
  position TEXT
);

CREATE TABLE professional_environment
(
  professional_environment_id INTEGER PRIMARY KEY,
  professional_environment_name VARCHAR(100) NOT NULL
);

CREATE TABLE specialization
(
  specialization_id INTEGER PRIMARY KEY,
  professional_environment_id INTEGER NOT NULL,
  specialization_name VARCHAR(100) NOT NULL,
  laboring BOOLEAN NOT NULL,
  FOREIGN KEY (professional_environment_id) REFERENCES professional_environment (professional_environment_id)
);

CREATE TABLE adviser_to_specialization
(
  adviser_id INTEGER NOT NULL REFERENCES adviser(id),
  specialization_id INTEGER NOT NULL REFERENCES specialization(specialization_id),

  PRIMARY KEY (adviser_id, specialization_id)
);

CREATE TABLE customer
(
    customer_id         SERIAL PRIMARY KEY,
    account_id          INTEGER NOT NULL REFERENCES account(id),
    name                TEXT,
    surname             TEXT
);

CREATE TABLE customer_problem
(
    customer_problem_id   SERIAL PRIMARY KEY,
    customer_id           INTEGER NOT NULL REFERENCES customer(customer_id),
    -- area_id               INTEGER NOT NULL,
    specialization_id     INTEGER NOT NULL REFERENCES specialization(specialization_id),
    consultation_type     adviserConsultationType,
    experience            adviserExperienceType,
    career_practice       adviserCareerType,
    customer_type         adviserCustomerType
);
