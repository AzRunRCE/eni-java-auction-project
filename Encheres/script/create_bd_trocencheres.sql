/****** Object:  Database [DB_ENCHERES]    Script Date: 11/04/2019 17:47:19 ******/
IF DB_ID('DB_ENCHERES') IS NOT NULL
BEGIN
USE master
ALTER DATABASE [DB_ENCHERES] SET  SINGLE_USER WITH ROLLBACK IMMEDIATE
DROP DATABASE DB_ENCHERES
END
GO
CREATE DATABASE DB_ENCHERES;
USE DB_ENCHERES;
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DB_ENCHERES].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DB_ENCHERES] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET ARITHABORT OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DB_ENCHERES] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DB_ENCHERES] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DB_ENCHERES] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DB_ENCHERES] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET RECOVERY FULL 
GO
ALTER DATABASE [DB_ENCHERES] SET  MULTI_USER 
GO
ALTER DATABASE [DB_ENCHERES] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DB_ENCHERES] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DB_ENCHERES] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DB_ENCHERES] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DB_ENCHERES] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DB_ENCHERES', N'ON'
GO
USE [DB_ENCHERES]
GO
/****** Object:  Table [dbo].[ARTICLES_VENDUS]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ARTICLES_VENDUS](
	[no_article] [int] IDENTITY(1,1) NOT NULL,
	[nom_article] [varchar](30) NOT NULL,
	[description] [varchar](300) NOT NULL,
	[date_debut_encheres] [datetime] NOT NULL,
	[date_fin_encheres] [datetime] NOT NULL,
	[prix_initial] [int] NULL,
	[prix_vente] [int] NULL,
	[chemin_image] [varchar](150) NULL,
	[no_utilisateur] [int] NOT NULL,
	[no_categorie] [int] NOT NULL,
 CONSTRAINT [articles_vendus_pk] PRIMARY KEY CLUSTERED 
(
	[no_article] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CATEGORIES]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CATEGORIES](
	[no_categorie] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](30) NOT NULL,
 CONSTRAINT [categorie_pk] PRIMARY KEY CLUSTERED 
(
	[no_categorie] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ENCHERES]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ENCHERES](
	[no_utilisateur] [int] NOT NULL,
	[no_article] [int] NOT NULL,
	[date_enchere] [datetime] NOT NULL,
	[montant_enchere] [int] NOT NULL,
 CONSTRAINT [enchere_pk] PRIMARY KEY CLUSTERED 
(
	[no_utilisateur] ASC,
	[no_article] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[RETRAITS]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RETRAITS](
	[no_article] [int] NOT NULL,
	[rue] [varchar](255) NOT NULL,
	[code_postal] [varchar](15) NOT NULL,
	[ville] [varchar](255) NOT NULL,
 CONSTRAINT [retrait_pk] PRIMARY KEY CLUSTERED 
(
	[no_article] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UTILISATEURS]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UTILISATEURS](
	[no_utilisateur] [int] IDENTITY(1,1) NOT NULL,
	[pseudo] [varchar](255) NOT NULL,
	[nom] [varchar](255) NOT NULL,
	[prenom] [varchar](255) NOT NULL,
	[email] [varchar](320) NOT NULL,
	[telephone] [varchar](255) NULL,
	[rue] [varchar](255) NOT NULL,
	[code_postal] [varchar](255) NOT NULL,
	[ville] [varchar](255) NOT NULL,
	[mot_de_passe] [varchar](255) NOT NULL,
	[credit] [int] NOT NULL,
	[administrateur] [bit] NOT NULL,
 CONSTRAINT [utilisateur_pk] PRIMARY KEY CLUSTERED 
(
	[no_utilisateur] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ARTICLES_VENDUS] ON 

GO
INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (1, N'VTT', N'efzfefef', CAST(N'2019-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, NULL, 1, 1)
GO
INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (2, N'VTT', N'efzfefef', CAST(N'2019-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, NULL, 1, 1)
GO
INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (3, N'VTT', N'efzfefef', CAST(N'2019-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, N'20190410013115.jpeg', 1, 1)
GO
INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (4, N'zdzddz', N'fdgffggf', CAST(N'1999-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, N'20190410013802.jpeg', 1, 1)
GO
SET IDENTITY_INSERT [dbo].[ARTICLES_VENDUS] OFF
GO
SET IDENTITY_INSERT [dbo].[CATEGORIES] ON 

GO
INSERT [dbo].[CATEGORIES] ([no_categorie], [libelle]) VALUES (1, N'Velos')
GO
INSERT [dbo].[CATEGORIES] ([no_categorie], [libelle]) VALUES (2, N'Voitures')
GO
SET IDENTITY_INSERT [dbo].[CATEGORIES] OFF
GO
INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (1, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')
GO
INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (2, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')
GO
INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (3, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')
GO
INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (4, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')
GO
SET IDENTITY_INSERT [dbo].[UTILISATEURS] ON 

GO
INSERT [dbo].[UTILISATEURS] ([no_utilisateur], [pseudo], [nom], [prenom], [email], [telephone], [rue], [code_postal], [ville], [mot_de_passe], [credit], [administrateur]) VALUES (1, N'ApoZLd', N'GABORIT', N'Romain', N'romain@gmail.com', N'0631212957', N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre', N'hello', 10, 1)
GO
INSERT [dbo].[UTILISATEURS] ([no_utilisateur], [pseudo], [nom], [prenom], [email], [telephone], [rue], [code_postal], [ville], [mot_de_passe], [credit], [administrateur]) VALUES (2, N'Fcatin', N'CATIN', N'Fabien', N'f.catin@gmail.com', N'06xxxxxxxx', N'route de bimedia', N'86000', N'La Roche sur Yon', N'coucou', 0, 0)
GO
SET IDENTITY_INSERT [dbo].[UTILISATEURS] OFF
GO
ALTER TABLE [dbo].[ARTICLES_VENDUS]  WITH CHECK ADD  CONSTRAINT [articles_vendus_categories_fk] FOREIGN KEY([no_categorie])
REFERENCES [dbo].[CATEGORIES] ([no_categorie])
GO
ALTER TABLE [dbo].[ARTICLES_VENDUS] CHECK CONSTRAINT [articles_vendus_categories_fk]
GO
ALTER TABLE [dbo].[ARTICLES_VENDUS]  WITH CHECK ADD  CONSTRAINT [encheres_utilisateur_fk] FOREIGN KEY([no_utilisateur])
REFERENCES [dbo].[UTILISATEURS] ([no_utilisateur])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ARTICLES_VENDUS] CHECK CONSTRAINT [encheres_utilisateur_fk]
GO
ALTER TABLE [dbo].[ARTICLES_VENDUS]  WITH CHECK ADD  CONSTRAINT [ventes_utilisateur_fk] FOREIGN KEY([no_utilisateur])
REFERENCES [dbo].[UTILISATEURS] ([no_utilisateur])
GO
ALTER TABLE [dbo].[ARTICLES_VENDUS] CHECK CONSTRAINT [ventes_utilisateur_fk]
GO
ALTER TABLE [dbo].[ENCHERES]  WITH CHECK ADD  CONSTRAINT [encheres_articles_vendus_fk] FOREIGN KEY([no_article])
REFERENCES [dbo].[ARTICLES_VENDUS] ([no_article])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ENCHERES] CHECK CONSTRAINT [encheres_articles_vendus_fk]
GO
ALTER TABLE [dbo].[RETRAITS]  WITH CHECK ADD  CONSTRAINT [retraits_articles_vendus_fk] FOREIGN KEY([no_article])
REFERENCES [dbo].[ARTICLES_VENDUS] ([no_article])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[RETRAITS] CHECK CONSTRAINT [retraits_articles_vendus_fk]
GO
USE [master]
GO
ALTER DATABASE [DB_ENCHERES] SET  READ_WRITE 
GO
