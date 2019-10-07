
-- H2 sql script create table

DROP TABLE IF EXISTS employee_info;

CREATE TABLE employee_info (
	id bigint AUTO_INCREMENT(1, 1) PRIMARY KEY, --IDENTITY NOT NULL PRIMARY KEY,
	first_name VARCHAR(200) NOT NULL,
	last_name VARCHAR(200) NOT NULL,
	company VARCHAR(200) DEFAULT NULL,
	address VARCHAR(200) DEFAULT NULL,
	salary DOUBLE DEFAULT 0.0
);


/*

-- MS SQL script create table

USE [ForexDB];

drop table dbo.employee_info;

CREATE TABLE [dbo].[employee_info](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	--[id] [varchar](10) NOT NULL,
	[first_name] [varchar](50) NULL,
	[last_name] [varchar](50) NULL,
	[company] [varchar](50) NULL,
	[address] [varchar](100) NULL,
	[salary] [money] NULL
) ON [PRIMARY]
*/

-- common script insert data


insert into employee_info (first_name, last_name, company, address, salary) values ('L', 'Liu', 'IBM', '1 plaza, Armonk, NY', 6666.66);
insert into employee_info (first_name, last_name, company, address, salary) values ('C', 'Liu', 'HSBC', '6 42nd st. NYC', 8888.88);
insert into employee_info (first_name, last_name, company, address, salary) values ('Q', 'Li', 'Pline', '8 time, NYC', 7777.77);
insert into employee_info (first_name, last_name, company, address, salary) values ('Y', 'Lin', 'IBM', '2 5th ave, NYC', 5555.55);
insert into employee_info (first_name, last_name, company, address, salary) values ('R', 'Lu', 'HSBC', '4 22th st., NYC', 1111.11);
insert into employee_info (first_name, last_name, company, address, salary) values ('T', 'Lao', 'Pline', '9 broad st, Stamord', 9999.99);