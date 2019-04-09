/****** Script de la commande SelectTopNRows à partir de SSMS  ******/
SELECT TOP 1000 [no_article]
      ,[nom_article]
      ,[description]
      ,[date_debut_encheres]
      ,[date_fin_encheres]
      ,[prix_initial]
      ,[prix_vente]
      ,[no_utilisateur]
      ,[no_categorie]
  FROM [DB_ENCHERES].[dbo].[ARTICLES_VENDUS]

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
  
  select * from UTILISATEURS
  select * from ARTICLES_VENDUS