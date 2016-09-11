drop table mykeyspace.employee if
CREATE TABLE mykeyspace.employee (
    id int,
    age int,
    joiningdate timestamp,
    name text,
    phone text,
    PRIMARY KEY (id)
)