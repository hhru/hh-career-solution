CREATE TABLE area
(
  area_id     INTEGER PRIMARY KEY,
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
  professional_environment_id INTEGER NOT NULL,
  specialization_name VARCHAR(100) NOT NULL,
  laboring BOOLEAN NOT NULL,
  FOREIGN KEY (professional_environment_id) REFERENCES professional_environment (professional_environment_id)
);
