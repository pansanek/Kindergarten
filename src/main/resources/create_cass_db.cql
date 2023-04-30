CREATE TABLE IF NOT EXISTS children (
  first_name text,
  second_name text,
  age int,
  group_name text,
  PRIMARY KEY ((second_name), first_name, group_name)
);

CREATE TABLE IF NOT EXISTS group (
  group_name text,
  number_of_children int,
  educator_name text,
  PRIMARY KEY (group_name)
);

CREATE TABLE IF NOT EXISTS educators (
  first_name text,
  second_name text,
  age int,
  PRIMARY KEY (second_name)
);

CREATE TABLE nutrition (
  day_of_week text,
  breakfast list<text> ,
  lunch list<text>,
  snack list<text>,
  dinner list<text>,
  PRIMARY KEY (day_of_week)
);

CREATE TABLE parents (
parent_id int PRIMARY KEY,
first_name text,
last_name text,
email text,
phone int,
work_place text
);

//CREATE TABLE IF NOT EXISTS kindergarten.children (
  child_name text,
  second_name text,
  age int,
  group_name text,
  PRIMARY KEY ((group_name), age, child_name)
);