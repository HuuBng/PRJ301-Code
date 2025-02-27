USE [PetStore]
GO
CREATE TABLE [Account](
	[Id] [int] IDENTITY(1,1) PRIMARY KEY,
	[Email] [varchar](50) NOT NULL,
	[Password] [char](64) NOT NULL,
	[FullName] [nvarchar](50) NOT NULL,
	[Role] [varchar](20) NOT NULL
)
GO

SET IDENTITY_INSERT [dbo].[Account] ON 
INSERT [dbo].[Account] ([id], [email], [password], [fullName], [role]) VALUES 
(1, 'admin@gmail.com', '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'Administrator', 'ADMIN'),
(2, 'john@gmail.com',  '6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'John Smith', 'USER')
SET IDENTITY_INSERT [dbo].[Account] OFF
GO