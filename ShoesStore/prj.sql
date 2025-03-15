USE [master]
GO
IF EXISTS (SELECT name FROM sys.databases WHERE name = 'ShoesStore')
BEGIN
    -- Set to single-user mode to terminate connections
    ALTER DATABASE [ShoesStore] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    
    -- Drop the database
    DROP DATABASE [ShoesStore];
END;
GO
/****** Object:  Database [ShoesStore]    Script Date: 3/10/2025 8:09:51 PM ******/
CREATE DATABASE [ShoesStore]
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ShoesStore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ShoesStore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ShoesStore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ShoesStore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ShoesStore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ShoesStore] SET ARITHABORT OFF 
GO
ALTER DATABASE [ShoesStore] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ShoesStore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ShoesStore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ShoesStore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ShoesStore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ShoesStore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ShoesStore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ShoesStore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ShoesStore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ShoesStore] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ShoesStore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ShoesStore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ShoesStore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ShoesStore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ShoesStore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ShoesStore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ShoesStore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ShoesStore] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ShoesStore] SET  MULTI_USER 
GO
ALTER DATABASE [ShoesStore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ShoesStore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ShoesStore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ShoesStore] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ShoesStore] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ShoesStore] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [ShoesStore] SET QUERY_STORE = ON
GO
ALTER DATABASE [ShoesStore] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [ShoesStore]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/10/2025 8:09:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Password] [char](64) NOT NULL,
	[FullName] [nvarchar](50) NOT NULL,
	[Role] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 3/10/2025 8:09:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[orderHeaderId] [int] NOT NULL,
	[shoesId] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
	[discount] [float] NOT NULL,
	[address] [nvarchar] (255) NOT NULL,
	[phone] [nvarchar] (20) NOT NULL,
	[size] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderHeader]    Script Date: 3/10/2025 8:09:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderHeader](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[date] [datetime] NOT NULL,
	[accountId] [int] NOT NULL,			
	[status] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shoes]    Script Date: 3/10/2025 8:09:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shoes](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[brand] [varchar](100) NOT NULL,
	[category] [varchar](100) NOT NULL,
	[size] [nvarchar](max) NOT NULL,
	[price] [decimal](10, 2) NOT NULL,
	[discount] [decimal](5, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([Id], [Email], [Password], [FullName], [Role]) VALUES (1, N'admin@gmail.com', N'1                                                               ', N'Administrator', N'ADMIN')
INSERT [dbo].[Account] ([Id], [Email], [Password], [FullName], [Role]) VALUES (2, N'john@gmail.com', N'1                                                               ', N'John Smith', N'USER')
INSERT [dbo].[Account] ([Id], [Email], [Password], [FullName], [Role]) VALUES (3, N'walter@gmail.com', N'2                                                               ', N'Walter White ', N'USER')
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Shoes] ON 

INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (1, N'Adidas Ultra Boost 5 Olive Real Boost', N'Adidas', N'ULTRA BOOST', N'[39,40, 41, 42, 43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.33 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (2, N'Adidas Ultra Boost 5 Glory Grey Real Boost', N'Adidas', N'ULTRA BOOST', N'[39,40, 41, 42, 43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.33 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (3, N'Adidas Ultra Boost Light Shoes Orange Real Boost', N'Adidas', N'ULTRA BOOST', N'[ 41, 42, 43,44,45]', CAST(2000000.00 AS Decimal(10, 2)), CAST(0.45 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (4, N'Adidas Ultraboost Light ‘Arctic Night’ Real Boost', N'Adidas', N'ULTRA BOOST', N'[40,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.38 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (5, N'Adidas Adizero Adios Pro 4 Ekiden Pack OEM', N'Adidas', N'Adizero Adios Pro 4', N'[39,40, 41, 42, 43,44,45]', CAST(1900000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (6, N'Adidas Adizero Adios Pro 4 White Black OEM', N'Adidas', N'Adizero Adios Pro 4', N'[39,40, 41, 42, 43,44,45]', CAST(2500000.00 AS Decimal(10, 2)), CAST(0.40 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (7, N'Adidas Adizero Adios Pro 4 White OEM', N'Adidas', N'Adizero Adios Pro 4', N'[36,37,38,39,40, 41, 42, 43,44,45]', CAST(1900000.00 AS Decimal(10, 2)), CAST(0.40 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (8, N'Adidas Adizero Adios Pro 3 Wonder Blue', N'Adidas', N'Adizero Adios Pro 3', N'[40, 41, 42, 43,44,45]', CAST(2000000.00 AS Decimal(10, 2)), CAST(0.20 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (9, N'Adidas Adizero Adios Pro 3 Core Black Solar Green', N'Adidas', N'Adizero Adios Pro 3', N'[40, 41, 42, 43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.38 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (10, N'Adidas Adizero Adios Pro 3 Shoes - White', N'Adidas', N'Adizero Adios Pro 3', N'[40, 41, 42, 43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.20 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (11, N'Adidas Adizero Evo SL White Best Quality', N'Adidas', N'Adizero Evo SL', N'[36,37,38,39,40, 41, 42, 43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.25 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (12, N'Adidas Adizero Evo SL Black Best Quality', N'Adidas', N'Adizero Evo SL', N'[39,40, 41, 42, 43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.25 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (13, N'Adidas Adizero Evo SL Lucid Lemon Best Quality', N'Adidas', N'Adizero Evo SL', N'[36,37,38,39,40, 41, 42, 43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.33 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (14, N'Adidas Adios Pro Evo 1 Pharrell Earth Best Quality', N'Adidas', N'Adizero Pro Evo 1', N'[36,37,38,39,40, 41, 42, 43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.30 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (15, N'Adidas Yeezy 350 Static Black Non Reflective Best Quality', N'Adidas', N'Yeezy 350', N'[36,37,38,39,40, 41, 42, 43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.28 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (16, N'Yeezy 350v2 Static BEST QUALITY', N'Adidas', N'Yeezy 350', N'[37,39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.25 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (17, N'Yeezy Boost 350 V2 MX Dark Salt', N'Adidas', N'Yeezy 350', N'[39,40, 41, 42, 43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.36 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (18, N'Air Zoom Pegasus 41 Black Sail Volt Glacier Blue', N'Nike', N'Nike Pegasus 41', N'[39,40,41,42,43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.33 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (19, N'Air Zoom Pegasus 41 Premium Sail Barely Grey OEM', N'Nike', N'Nike Pegasus 41', N'[36,37,38,39,40]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.25 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (20, N'Air Zoom Pegasus 41 Wherever Whenever OEM', N'Nike', N'Nike Pegasus 41', N'[36,37,38,39,40]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.38 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (21, N'Air Zoom Pegasus 40 Black Speed Yellow OEM', N'Nike', N'Nike Pegasus 40', N'[40,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.38 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (22, N'Air Zoom Pegasus 40 Triple Black OEM', N'Nike', N'Nike Pegasus 40', N'[44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.45 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (23, N'Air Zoom Pegasus 40 Platinum Tint OEM', N'Nike', N'Nike Pegasus 40', N'[42,43,44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.20 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (24, N'Nike Air Zoom Fly 5 Eliud Kipchoge OEM', N'Nike', N'Nike Zoom Fly 5', N'[39,40,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (25, N'Nike Air Zoom Fly 5 Black Ghost Green OEM', N'Nike', N'Nike Zoom Fly 5', N'[39,41,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (26, N'Nike Air Zoom Fly 5 Orange OEM', N'Nike', N'Nike Zoom Fly 5', N'[39,41,44,45]', CAST(2200000.00 AS Decimal(10, 2)), CAST(0.50 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (27, N'Nike Air Force 1 Low Valentines Day', N'Nike', N'Nike Air Force 1', N'[39,40,41,44,45]', CAST(1000000.00 AS Decimal(10, 2)), CAST(0.40 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (28, N'Air Force 1 Low Ambush', N'Nike', N'Nike Air Force 1', N'[38,39,40,41,42,43,44,45]', CAST(1000000.00 AS Decimal(10, 2)), CAST(0.21 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (29, N'Nike Air Force 1 Low All White Best Quality', N'Nike', N'Nike Air Force 1', N'[36,37,38,39,40,41,42,43,44,45]', CAST(1250000.00 AS Decimal(10, 2)), CAST(0.24 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (30, N'Nike Air Force 1 Low White University Red Best Quality', N'Nike', N'Nike Air Force 1', N'[39,40,41,44,45]', CAST(1250000.00 AS Decimal(10, 2)), CAST(0.50 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (31, N'Nike Air Force 1 MID White Best Quality', N'Nike', N'Nike Air Force 1', N'[39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.25 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (32, N'Air Jordan 1 Low White Univeristy Red Best Quality', N'Jordan', N'Jordan 1', N'[37,38,39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (33, N'Air Jordan 1 Low Green Toe Best Quality', N'Jordan', N'Jordan 1', N'[39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (34, N'Air Jordan 1 Low ‘Blue Sashiko’ Best Quality', N'Jordan', N'Jordan 1', N'[39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.25 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (35, N'Nike Jordan 1 Low Travis Scott Best Quality', N'Jordan', N'Jordan 1', N'[39,40,41,42,43,44,45]', CAST(2200000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (36, N'Nike Air Jordan Low 1 Blue White Best Quality', N'Jordan', N'Jordan 1', N'[39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (37, N'Nike Air Jordan 3 Retro Tinker White University Red Best Quality', N'Jordan', N'Jordan 3', N'[39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.28 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (38, N'Nike Air Jordan 3 Retro Luck Green Best Quality', N'Jordan', N'Jordan 3', N'[36,37,38,39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.28 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (39, N'Nike Air Jordan 3 Retro SE Fire Red Denim Best Quality', N'Jordan', N'Jordan 3', N'[39,40,41,42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.25 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (40, N'Nike Air Jordan 3 Retro " Katrina/Hall Of Fame Best Quality', N'Jordan', N'Jordan 3', N'[42,43,44,45]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.35 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (41, N'Jordan 4 Retro SB Pine Green Best Quality', N'Jordan', N'Jordan 4', N'[40,41,42,43,44]', CAST(1600000.00 AS Decimal(10, 2)), CAST(0.31 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (42, N'Jordan 4 Retro White Cement BEST QUALITY', N'Jordan', N'Jordan 4', N'[39,40,41,42,43,44]', CAST(2200000.00 AS Decimal(10, 2)), CAST(0.40 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (43, N'Pickleball Tennis Asics Gel Resolution 9 White Blue', N'ASICS', N'Gel Resolution 9', N'[39,40,41,42,43,44,45]', CAST(1900000.00 AS Decimal(10, 2)), CAST(0.34 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (44, N'Pickleball Tennis Asics Gel Resolution 9 Paris Neon', N'ASICS', N'Gel Resolution 9', N'[39,40,41,42,43,44,45]', CAST(1900000.00 AS Decimal(10, 2)), CAST(0.34 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (45, N'Pickleball Tennis Asics Gel Resolution 9 White', N'ASICS', N'Gel Resolution 9', N'[36,37,38,39,40,41,42,43,44,45]', CAST(1900000.00 AS Decimal(10, 2)), CAST(0.34 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (46, N'Asics Gel Kayano 30 AnniverSary White Deep Ocean Best Quality', N'ASICS', N'Gel Kayano 30', N'[44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.33 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (47, N'Asics Gel Kayano 30 French Blue Neon Lime Best Quality', N'ASICS', N'Gel Kayano 30', N'[44,45]', CAST(1800000.00 AS Decimal(10, 2)), CAST(0.33 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (48, N'Adidas Sandal Terrex Cyprex Ultra DLX Grey', N'Sandal and Slide', N'Sandal', N'[41,42,43,44,45]', CAST(1200000.00 AS Decimal(10, 2)), CAST(0.43 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (49, N'Adidas Sandal Terrex Cyprex Ultra DLX Navy', N'Sandal and Slide', N'Sandal', N'[39,41,43,44,45]', CAST(1200000.00 AS Decimal(10, 2)), CAST(0.43 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (50, N'Adidas Terrex Cyprex Ultra 2 Sandal Black', N'Sandal and Slide', N'Sandal', N'[44,45]', CAST(1200000.00 AS Decimal(10, 2)), CAST(0.43 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (51, N'MLB LA Navy', N'Sandal and Slide', N'Slide ', N'[37,39,40,41]', CAST(1000000.00 AS Decimal(10, 2)), CAST(0.50 AS Decimal(5, 2)))
INSERT [dbo].[Shoes] ([id], [name], [brand], [category], [size], [price], [discount]) VALUES (52, N'Fila Tr?ng', N'Sandal and Slide', N'Slide', N'[36,37,38,39,40]', CAST(1200000.00 AS Decimal(10, 2)), CAST(0.50 AS Decimal(5, 2)))
SET IDENTITY_INSERT [dbo].[Shoes] OFF
GO
ALTER TABLE [dbo].[OrderHeader] ADD  DEFAULT ('New') FOR [status]
GO
ALTER TABLE [dbo].[Shoes] ADD  DEFAULT ((0.00)) FOR [discount]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([orderHeaderId])
REFERENCES [dbo].[OrderHeader] ([id])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([shoesId])
REFERENCES [dbo].[Shoes] ([id])
GO
ALTER TABLE [dbo].[OrderHeader]  WITH CHECK ADD FOREIGN KEY([accountId])
REFERENCES [dbo].[Account] ([Id])
GO
ALTER TABLE [dbo].[OrderHeader]  WITH CHECK ADD CHECK  (([status]='Paid' OR [status]='Shipping' OR [status]='New'))
GO
USE [master]
GO
ALTER DATABASE [ShoesStore] SET  READ_WRITE 
GO
