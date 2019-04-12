/****** Object:  Database [DB_ENCHERES]    Script Date: 11/04/2019 17:47:19 ******/
IF DB_ID('DB_ENCHERES') IS NOT NULL
BEGIN
USE master
ALTER DATABASE [DB_ENCHERES] SET  SINGLE_USER WITH ROLLBACK IMMEDIATE
DROP DATABASE DB_ENCHERES
END

CREATE DATABASE DB_ENCHERES;
USE DB_ENCHERES;

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DB_ENCHERES].[dbo].[sp_fulltext_database] @action = 'enable'
end

ALTER DATABASE [DB_ENCHERES] SET ANSI_NULL_DEFAULT OFF 

ALTER DATABASE [DB_ENCHERES] SET ANSI_NULLS OFF 

ALTER DATABASE [DB_ENCHERES] SET ANSI_PADDING OFF 

ALTER DATABASE [DB_ENCHERES] SET ANSI_WARNINGS OFF 

ALTER DATABASE [DB_ENCHERES] SET ARITHABORT OFF 

ALTER DATABASE [DB_ENCHERES] SET AUTO_CLOSE OFF 

ALTER DATABASE [DB_ENCHERES] SET AUTO_SHRINK OFF 

ALTER DATABASE [DB_ENCHERES] SET AUTO_UPDATE_STATISTICS ON 

ALTER DATABASE [DB_ENCHERES] SET CURSOR_CLOSE_ON_COMMIT OFF 

ALTER DATABASE [DB_ENCHERES] SET CURSOR_DEFAULT  GLOBAL 

ALTER DATABASE [DB_ENCHERES] SET CONCAT_NULL_YIELDS_NULL OFF 

ALTER DATABASE [DB_ENCHERES] SET NUMERIC_ROUNDABORT OFF 

ALTER DATABASE [DB_ENCHERES] SET QUOTED_IDENTIFIER OFF 

ALTER DATABASE [DB_ENCHERES] SET RECURSIVE_TRIGGERS OFF 

ALTER DATABASE [DB_ENCHERES] SET  ENABLE_BROKER 

ALTER DATABASE [DB_ENCHERES] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 

ALTER DATABASE [DB_ENCHERES] SET DATE_CORRELATION_OPTIMIZATION OFF 

ALTER DATABASE [DB_ENCHERES] SET TRUSTWORTHY OFF 

ALTER DATABASE [DB_ENCHERES] SET ALLOW_SNAPSHOT_ISOLATION OFF 

ALTER DATABASE [DB_ENCHERES] SET PARAMETERIZATION SIMPLE 

ALTER DATABASE [DB_ENCHERES] SET READ_COMMITTED_SNAPSHOT OFF 

ALTER DATABASE [DB_ENCHERES] SET HONOR_BROKER_PRIORITY OFF 

ALTER DATABASE [DB_ENCHERES] SET RECOVERY FULL 

ALTER DATABASE [DB_ENCHERES] SET  MULTI_USER 

ALTER DATABASE [DB_ENCHERES] SET PAGE_VERIFY CHECKSUM  

ALTER DATABASE [DB_ENCHERES] SET DB_CHAINING OFF 

ALTER DATABASE [DB_ENCHERES] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 

ALTER DATABASE [DB_ENCHERES] SET TARGET_RECOVERY_TIME = 60 SECONDS 

ALTER DATABASE [DB_ENCHERES] SET DELAYED_DURABILITY = DISABLED 

EXEC sys.sp_db_vardecimal_storage_format N'DB_ENCHERES', N'ON'

USE [DB_ENCHERES]
GO;
/****** Object:  Table [dbo].[ARTICLES_VENDUS]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

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


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[CATEGORIES]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[CATEGORIES](
	[no_categorie] [int] IDENTITY(1,1) NOT NULL,
	[libelle] [varchar](30) NOT NULL,
 CONSTRAINT [categorie_pk] PRIMARY KEY CLUSTERED 
(
	[no_categorie] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[ENCHERES]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

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


/****** Object:  Table [dbo].[RETRAITS]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

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


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[UTILISATEURS]    Script Date: 11/04/2019 17:47:20 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

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


SET ANSI_PADDING OFF

SET IDENTITY_INSERT [dbo].[ARTICLES_VENDUS] ON 


INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (1, N'VTT', N'efzfefef', CAST(N'2019-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, NULL, 1, 1)

INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (2, N'VTT', N'efzfefef', CAST(N'2019-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, NULL, 1, 1)

INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (3, N'VTT', N'efzfefef', CAST(N'2019-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, N'20190410013115.jpeg', 1, 1)

INSERT [dbo].[ARTICLES_VENDUS] ([no_article], [nom_article], [description], [date_debut_encheres], [date_fin_encheres], [prix_initial], [prix_vente], [chemin_image], [no_utilisateur], [no_categorie]) VALUES (4, N'zdzddz', N'fdgffggf', CAST(N'1999-10-10 10:10:00.000' AS DateTime), CAST(N'2019-10-10 10:10:00.000' AS DateTime), 100, 100, N'20190410013802.jpeg', 1, 1)

SET IDENTITY_INSERT [dbo].[ARTICLES_VENDUS] OFF

SET IDENTITY_INSERT [dbo].[CATEGORIES] ON 


INSERT [dbo].[CATEGORIES] ([no_categorie], [libelle]) VALUES (1, N'Velos')

INSERT [dbo].[CATEGORIES] ([no_categorie], [libelle]) VALUES (2, N'Voitures')

SET IDENTITY_INSERT [dbo].[CATEGORIES] OFF

INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (1, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')

INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (2, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')

INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (3, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')

INSERT [dbo].[RETRAITS] ([no_article], [rue], [code_postal], [ville]) VALUES (4, N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre')

SET IDENTITY_INSERT [dbo].[UTILISATEURS] ON 


INSERT [dbo].[UTILISATEURS] ([no_utilisateur], [pseudo], [nom], [prenom], [email], [telephone], [rue], [code_postal], [ville], [mot_de_passe], [credit], [administrateur]) VALUES (1, N'ApoZLd', N'GABORIT', N'Romain', N'romain@gmail.com', N'0631212957', N'Allee des fougeres', N'44240', N'La Chapelle sur Erdre', N'hello', 10, 1)

INSERT [dbo].[UTILISATEURS] ([no_utilisateur], [pseudo], [nom], [prenom], [email], [telephone], [rue], [code_postal], [ville], [mot_de_passe], [credit], [administrateur]) VALUES (2, N'Fcatin', N'CATIN', N'Fabien', N'f.catin@gmail.com', N'06xxxxxxxx', N'route de bimedia', N'86000', N'La Roche sur Yon', N'coucou', 0, 0)

SET IDENTITY_INSERT [dbo].[UTILISATEURS] OFF

ALTER TABLE [dbo].[ARTICLES_VENDUS]  WITH CHECK ADD  CONSTRAINT [articles_vendus_categories_fk] FOREIGN KEY([no_categorie])
REFERENCES [dbo].[CATEGORIES] ([no_categorie])

ALTER TABLE [dbo].[ARTICLES_VENDUS] CHECK CONSTRAINT [articles_vendus_categories_fk]

ALTER TABLE [dbo].[ARTICLES_VENDUS]  WITH CHECK ADD  CONSTRAINT [encheres_utilisateur_fk] FOREIGN KEY([no_utilisateur])
REFERENCES [dbo].[UTILISATEURS] ([no_utilisateur])
ON DELETE CASCADE

ALTER TABLE [dbo].[ARTICLES_VENDUS] CHECK CONSTRAINT [encheres_utilisateur_fk]

ALTER TABLE [dbo].[ARTICLES_VENDUS]  WITH CHECK ADD  CONSTRAINT [ventes_utilisateur_fk] FOREIGN KEY([no_utilisateur])
REFERENCES [dbo].[UTILISATEURS] ([no_utilisateur])

ALTER TABLE [dbo].[ARTICLES_VENDUS] CHECK CONSTRAINT [ventes_utilisateur_fk]

ALTER TABLE [dbo].[ENCHERES]  WITH CHECK ADD  CONSTRAINT [encheres_articles_vendus_fk] FOREIGN KEY([no_article])
REFERENCES [dbo].[ARTICLES_VENDUS] ([no_article])
ON DELETE CASCADE

ALTER TABLE [dbo].[ENCHERES] CHECK CONSTRAINT [encheres_articles_vendus_fk]

ALTER TABLE [dbo].[RETRAITS]  WITH CHECK ADD  CONSTRAINT [retraits_articles_vendus_fk] FOREIGN KEY([no_article])
REFERENCES [dbo].[ARTICLES_VENDUS] ([no_article])
ON DELETE CASCADE

ALTER TABLE [dbo].[RETRAITS] CHECK CONSTRAINT [retraits_articles_vendus_fk]

USE [master]

ALTER DATABASE [DB_ENCHERES] SET  READ_WRITE 

