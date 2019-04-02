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