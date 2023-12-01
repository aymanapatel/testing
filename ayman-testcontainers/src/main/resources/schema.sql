DROP TABLE IF EXISTS customers;
--MySQL
-- Postgres does not have `auto_imncement`
--CREATE TABLE customers(id int not null auto_increment primary key, first_name VARCHAR(255), last_name VARCHAR(255));
--insert into customers (first_name, last_name) values ('ayman', 'patel');
--insert into customers (first_name, last_name) values ('john', 'doe');

-- Postgres
CREATE TABLE customers(id serial not null  primary key, first_name VARCHAR(255), last_name VARCHAR(255));
insert into customers (first_name, last_name) values ('ayman', 'patel');
insert into customers (first_name, last_name) values ('john', 'doe');



CREATE TABLE demoentity(id serial not null  primary key, value VARCHAR(255));
insert into demoentity (value) values ('ayman');