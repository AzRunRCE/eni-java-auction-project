INSERT INTO UTILISATEURS VALUES 
('ApoZLd', 'GABORIT', 'Romain', 'romain@gmail.com', '0631212957', 'Allee des fougeres',
 '44240', 'La Chapelle sur Erdre', 'hello', 11550, 1),
 ('Fcatin', 'CATIN', 'Fabien', 'f.catin@gmail.com', '06xxxxxxxx', 'route de bimedia',
 '85000', 'La Roche sur Yon', 'coucou', 55103, 1),
 ('AzRun', 'MARTINEZ', 'Quentin', 'adresse@gmail.com', '06xxxxxxxx', 'rue principale',
 '35000', 'Rennes', 'pass', 4148, 0);
 
 
INSERT INTO CATEGORIES VALUES('Informatique'), ('Ameublement'), ('Vêtement'), ('Sport & Loisir');	

INSERT INTO ARTICLES_VENDUS VALUES('PC HP 450-G5', 'Super PC état comme neuf, processeur Intel Core I7 16GO DDR4', '2019-11-04 09:32', '2019-11-05 09:32', 300, 300, '20190410032640.jpeg', 2, 1);
INSERT INTO ARTICLES_VENDUS VALUES('Veste en cuir noir', 'Superbe veste en véritable cuir noir. Taille L, très peu porté', '2019-12-04 09:32', '2019-12-05 09:32', 150, 150, '20190412094910.jpeg', 1, 3);

INSERT INTO RETRAITS (1, 'route de bimedia', '85000', 'La Roche sur Yon');
INSERT INTO RETRAITS (2, 'Allee des fougeres', '44240', 'La Chapelle sur Erdre');

INSERT INTO ENCHERES (3, 1, '2019-04-11 10:42', 302);
INSERT INTO ENCHERES (3, 2, '2019-04-12 10:25', 550);