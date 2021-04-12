CREATE TABLE area
(
  area_id     INTEGER PRIMARY KEY NOT NULL,
  name   VARCHAR(100) NOT NULL
);

CREATE TABLE professional_environment
(
  professional_environment_id INTEGER PRIMARY KEY,
  professional_environment_name VARCHAR(100) NOT NULL
);

CREATE TABLE specialization
(
  specialization_id INTEGER PRIMARY KEY,
  professional_environment_id INTEGER,
  specialization_name VARCHAR(100),
  laboring BOOLEAN,
  FOREIGN KEY (professional_environment_id) REFERENCES professional_environment (professional_environment_id)
);
