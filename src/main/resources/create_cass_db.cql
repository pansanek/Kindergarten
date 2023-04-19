CREATE TABLE IF NOT EXISTS kindergarten.children (
  child_name text,
  second_name text,
  age int,
  group_name text,
  PRIMARY KEY ((group_name), age, child_name)
);