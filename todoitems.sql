DROP TABLE IF EXISTS todoitems;

CREATE TABLE todoitems
(
  id serial NOT NULL,
  title text,
  done boolean,
  CONSTRAINT todoitems_pkey PRIMARY KEY (id)
);

INSERT INTO todoitems (title, done) VALUES ('test', FALSE);
