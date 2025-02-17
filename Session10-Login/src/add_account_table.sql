USE [Toyz]
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
(1, 'admin@gmail.com', '1', N'Administrator', 'ADMIN'),
(2, 'john@gmail.com',  '1', N'John Smith', 'USER')
SET IDENTITY_INSERT [dbo].[Account] OFF
GO