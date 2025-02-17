set nocount on
USE master
GO

if exists (select * from sysdatabases where name='Toyz')
begin
  raiserror('Dropping existing Toyz database ....',0,1)
  DROP database Toyz
end
GO

CHECKPOINT
go

raiserror('Creating Toyz database....',0,1)
go
   CREATE DATABASE Toyz
GO

CHECKPOINT
GO

USE Toyz
GO

raiserror('Creating Table Brand....',0,1)
create table Brand
(
	Id	char(3) primary key clustered,
	Name	varchar(20) not null,
)
go
raiserror('Creating Table Toy....',0,1)
/* toys table */
create table Toy
(
	Id	char(3) primary key clustered,				
	Name	varchar(20) not null,
	Price  	money not null,
	ExpDate datetime,
	Brand	char(3) references Brand(Id),
)
/*****************************************************/
-- Populating data into the tables
/********************/

/* data for brand  */
INSERT INTO Brand values('001','Bobby ')
INSERT INTO Brand values('002','The Bernie Kids')

/* data for toy  */
insert into toy values('001','Robby the Whale ',2 ,'2026/01/20','001')
insert into toy values('002','Water Channel System ',10,'2028/02/25','001')
insert into toy values('003','Parachute and Rocket ',6,'2030/03/30','002')

raiserror('The Toyz database in now ready for use....',0,1)
