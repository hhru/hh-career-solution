CREATE TABLE IF NOT EXISTS adviser
(
  adviser_id SERIAL NOT NULL UNIQUE PRIMARY KEY,
  name VARCHAR NOT NULL,
  surname VARCHAR NOT NULL,
  created TIMESTAMP NOT NULL DEFAULT now(),
  updated TIMESTAMP NOT NULL DEFAULT now()
);

INSERT INTO adviser (name, surname)
VALUES ('Дима', 'Васянин');
INSERT INTO adviser (name, surname)
VALUES ('Дима', 'Васянин');
INSERT INTO adviser (name, surname)
VALUES ('Дима', 'Васянин');
