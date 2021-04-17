CREATE TABLE IF NOT EXISTS country
(
  id       SERIAL PRIMARY KEY,
  iso_code VARCHAR(2) UNIQUE NOT NULL,
  name     VARCHAR           NOT NULL,
  created  TIMESTAMP         NOT NULL,
  updated  TIMESTAMP         NOT NULL
);

CREATE TABLE IF NOT EXISTS area
(
  id               SERIAL PRIMARY KEY,
  country_iso_code VARCHAR   NOT NULL REFERENCES country (iso_code),
  name             VARCHAR   NOT NULL,
  created          TIMESTAMP NOT NULL,
  updated          TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS educational_institution
(
  id               SERIAL PRIMARY KEY,
  country_iso_code VARCHAR(2) NOT NULL REFERENCES country (iso_code),
  name             VARCHAR    NOT NULL,
  site             TEXT,
  created          TIMESTAMP  NOT NULL,
  updated          TIMESTAMP  NOT NULL
);

CREATE TABLE IF NOT EXISTS professional_field
(
  id      SERIAL PRIMARY KEY,
  name    VARCHAR   NOT NULL,
  created TIMESTAMP NOT NULL,
  updated TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS professional_association
(
  id      SERIAL PRIMARY KEY,
  name    VARCHAR   NOT NULL,
  created TIMESTAMP NOT NULL,
  updated TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS educational_period
(
  id        SERIAL PRIMARY KEY,
  year_from DATE NOT NULL,
  year_to   DATE NOT NULL
);

CREATE TYPE adviser_consultation_type AS ENUM ('offline', 'online', 'all');

CREATE TYPE adviser_experience_type AS ENUM ('от 5 мес - до 1 г', 'от 1 г - 3 лет', 'от 3 - до 6', 'более 6 лет');

CREATE TYPE adviser_career_type AS ENUM ('Карьерные консультации', 'Карьерный коучинг', 'Использую обе практики');

CREATE TYPE adviser_customer_type AS ENUM ('Нет опыта', 'Специалисты и эксперты', 'Средний менеджмент', 'Топ менеджмент');

CREATE TYPE adviser_problem_type AS ENUM ('Любые проблемы', 'Решала по жизни', 'Договоримся на месте');

CREATE TABLE IF NOT EXISTS adviser
(
  id              SERIAL    NOT NULL UNIQUE PRIMARY KEY,
  name            VARCHAR   NOT NULL,
  surname         VARCHAR   NOT NULL,
  area_id         INTEGER   NOT NULL REFERENCES area (id),
  consultation    adviser_consultation_type,
  experience      adviser_experience_type,
  career_practice adviser_career_type,
  customer_type adviser_customer_type,
  problem_type adviser_problem_type,
  created         TIMESTAMP NOT NULL,
  updated         TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS adviser_to_educational
(
  adviser_id                 INTEGER   NOT NULL REFERENCES adviser (id),
  educational_institution_id INTEGER   NOT NULL REFERENCES educational_institution (id),
  educational_period_id      INTEGER   NOT NULL REFERENCES educational_period (id),
  document_link                   TEXT,
  created                    TIMESTAMP NOT NULL,
  updated                    TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS adviser_to_professional_field
(
  adviser_id                 INTEGER   NOT NULL REFERENCES adviser (id),
  professional_field_id INTEGER   NOT NULL REFERENCES professional_field (id),
  created                    TIMESTAMP NOT NULL,
  updated                    TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS adviser_to_professional_association
(
  adviser_id                 INTEGER   NOT NULL REFERENCES adviser (id),
  professional_association_id INTEGER   NOT NULL REFERENCES professional_association (id),
  created                    TIMESTAMP NOT NULL,
  updated                    TIMESTAMP NOT NULL
);

INSERT INTO public.country (iso_code, name, created, updated) VALUES ('RU', 'Россия', '2021-04-12 22:42:32.000000', '2021-04-12 22:42:34.000000');
INSERT INTO public.area (country_iso_code, name, created, updated) VALUES ('RU', 'Москва', '2021-04-12 22:44:23.000000', '2021-04-12 22:44:25.000000');
INSERT INTO public.adviser (name, surname, area_id, consultation, experience, career_practice, customer_type, problem_type, created, updated) VALUES ('Дмитрий', 'Васянин', 1, 'all', 'от 1 г - 3 лет', 'Использую обе практики', 'Топ менеджмент', 'Договоримся на месте', '2021-04-12 22:46:35.000000', '2021-04-12 22:46:36.000000');
