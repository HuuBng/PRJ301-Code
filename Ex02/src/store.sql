set nocount on
USE master
GO

if exists (select * from sysdatabases where name='store')
begin
  raiserror('Dropping existing store database ....',0,1)
  DROP database store
end
GO

CHECKPOINT
go

raiserror('Creating store database....',0,1)
go
   CREATE DATABASE store
GO

CHECKPOINT
GO

USE store
GO

raiserror('Creating Table Product....',0,1)
create table Product
(
	id	int identity primary key clustered,
	name	varchar(20) not null,
	price float not null,
	expDate datetime not null
)
go

/*****************************************************/
-- Populating data into the tables
/********************/
raiserror('Populating data into the tables....',0,1)
INSERT INTO product values
('Desktop',1000,'2025-12-30'),
('Laptop' ,1200,'2025-10-25'),
('Printer',200 ,'2025-08-16')

raiserror('The store database is now ready for use....',0,1)
