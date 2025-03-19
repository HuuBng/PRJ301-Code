set nocount on
USE master
GO

print('Creating the database EmployeeManagement....')
CREATE DATABASE EmployeeManagement
GO

USE EmployeeManagement
GO
create table Account(
	Id [int] identity primary key,
	Email [varchar](50) NOT NULL,
	FullName [nvarchar](50) NOT NULL,
	RoleId [char](2) NOT NULL,
	Password [varchar](20) NOT NULL
)
GO
create table Employee
(
	Id int identity primary key,				
	FullName varchar(50) not null,
	DoB datetime not null,
	Salary float not null
)
GO
print('Populating data into tables....')
insert into Account values
('admin@gmail.com','David Smith','AM','1'),
('user@gmail.com','John Smith','US','2')
GO
insert into Employee values
('John Smith','2020/01/20',1500),
('Levis Williams','2021/02/25',1750),
('Marry Taylor','2022/03/30',1850)
GO
print('The database EmployeeManagement now ready for use.')
