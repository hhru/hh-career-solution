CREATE TABLE area
(
  area_id     INTEGER PRIMARY KEY,
  name   VARCHAR(100) NOT NULL
);

CREATE TABLE professional_environment
(
  env_id INTEGER PRIMARY KEY,
  env_name VARCHAR(100) NOT NULL
);

CREATE TABLE specialization
(
  spec_id INTEGER PRIMARY KEY,
  env_id INTEGER,
  spec_name VARCHAR(100),
  laboring BOOLEAN,
  FOREIGN KEY (environment_id) REFERENCES professional_environment (env_id)
);