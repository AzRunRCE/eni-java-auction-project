-- Script de création de la base de données ENCHERES
--   type :      SQL Server 2012
--
ALTER DATABASE DB_ENCHERES
SET SINGLE_USER
WITH ROLLBACK IMMEDIATE;
DROP DATABASE DB_ENCHERES;
IF DB_ID('DB_ENCHERES_UnitTests') IS NOT NULL
BEGIN
USE master
ALTER DATABASE [DB_ENCHERES_UnitTests] SET  SINGLE_USER WITH ROLLBACK IMMEDIATE
DROP DATABASE DB_ENCHERES_UnitTests
CREATE DATABASE DB_ENCHERES_UnitTests
USE DB_ENCHERES_UnitTests
END

CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)

ALTER TABLE CATEGORIES ADD constraint categorie_pk PRIMARY KEY (no_categorie)

CREATE TABLE ENCHERES (
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
    date_enchere     datetime NOT NULL,
	montant_enchere  INTEGER NOT NULL

)

ALTER TABLE ENCHERES ADD constraint enchere_pk PRIMARY KEY (no_utilisateur, no_article)

CREATE TABLE RETRAITS (
	no_article         INTEGER NOT NULL,
    rue              VARCHAR(255) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(255) NOT NULL
)

ALTER TABLE RETRAITS ADD constraint retrait_pk PRIMARY KEY  (no_article)

CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(255) NOT NULL,
    nom              VARCHAR(255) NOT NULL,
    prenom           VARCHAR(255) NOT NULL,
    email            VARCHAR(320) NOT NULL,
    telephone        VARCHAR(255),
    rue              VARCHAR(255) NOT NULL,
    code_postal      VARCHAR(255) NOT NULL,
    ville            VARCHAR(255) NOT NULL,
    mot_de_passe     VARCHAR(255) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL
)

ALTER TABLE UTILISATEURS ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)


CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
	date_debut_encheres           datetime NOT NULL,
    date_fin_encheres             datetime NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    chemin_image                  VARCHAR(150),  
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL
)

ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE RETRAITS
    ADD CONSTRAINT retraits_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION 
    ON UPDATE no action 

ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( no_utilisateur )
        REFERENCES utilisateurs ( no_utilisateur )
ON DELETE NO ACTION 
    ON UPDATE no action 

INSERT INTO UTILISATEURS VALUES 
('ApoZLd', 'GABORIT', 'Romain', 'romain@gmail.com', '0631212957', 'Allee des fougeres',
 '44240', 'La Chapelle sur Erdre', 'hello', 10, 1),
 ('Fcatin', 'CATIN', 'Fabien', 'f.catin@gmail.com', '06xxxxxxxx', 'route de bimedia',
 '86000', 'La Roche sur Yon', 'coucou', 0, 0);
 
INSERT INTO CATEGORIES VALUES('Velos'), ('Voitures');
 
INSERT INTO ARTICLES_VENDUS VALUES('Velo Giant', 'VTT', '2018-02-04', '2018-03-04', 30, 120, 1, 1),
                            ('207 5P', 'Voitures', '2018-02-06', '2018-03-07', 3000, 5200, 2, 2);
							
INSERT INTO ENCHERES VALUES(1, 1, '2018-02-04', 120), (2, 2, '2018-02-06', 3000);

INSERT INTO RETRAITS VALUES(1, 'rue du retrait', 44470, 'Carquefou'),
(2, 'rue du retrait', 44600, 'Saint Herblain');				


ALTER TABLE ENCHERES DROP CONSTRAINT encheres_articles_vendus_fk 
ALTER TABLE ARTICLES_VENDUS DROP CONSTRAINT encheres_utilisateur_fk 
ALTER TABLE RETRAITS DROP CONSTRAINT retraits_articles_vendus_fk 

ALTER TABLE ENCHERES 
ADD CONSTRAINT encheres_articles_vendus_fk 
FOREIGN KEY (no_article) 
REFERENCES ARTICLES_VENDUS(no_article) 
ON DELETE CASCADE;

ALTER TABLE RETRAITS 
ADD CONSTRAINT retraits_articles_vendus_fk 
FOREIGN KEY (no_article) 
REFERENCES ARTICLES_VENDUS(no_article) 
ON DELETE CASCADE;

ALTER TABLE ARTICLES_VENDUS 
ADD CONSTRAINT encheres_utilisateur_fk 
FOREIGN KEY (no_utilisateur) 
REFERENCES UTILISATEURS(no_utilisateur) 
ON DELETE CASCADE;


