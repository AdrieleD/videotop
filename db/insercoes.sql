-- --------------------- Tabela ator ---------------------
INSERT INTO videotopdb.ator (nome, dataNascimento) 
VALUES  ('Daniel Radcliffe','1989-07-23'),
		('Emma Watson','1990-04-15'),
        ('Rupert Grint','1988-08-24'),
        ('Leonardo Alves','1996-11-25'),
        ('Alan Rickman','1946-02-21'),
        ('Bruce Willis','1955-03-19'),
        ('Joseph Gordon-Levitt','1981-02-17'),
        ('Christian Bale','1974-01-30'),
        ('Jennifer Lawrence','1990-08-15'),
        ('James McAvoy','1979-04-21'),
        ('Michael Fassbender','1977-04-02'),
        ('Nicholas Hoult','1989-12-07'),
        ('Rosie Huntington-Whiteley','1987-04-18'),
        ('Shia LaBeouf','1986-06-11'),
        ('Owen Wilson','1968-11-18'),
        ('Tom Hanks','1959-07-09'),
        ('Richard Harris','1930-10-01'),
        ('Michael Gambon','1940-10-19'),
		('Brad Pitt','1963-12-18');
-- -------------------------------------------------------

-- --------------------- Tabela filme ---------------------
INSERT INTO videotopdb.filme (titulo,ano)
VALUES 	('Harry Potter e a Pedra Filosofal','2001'),
		('A mulher de Preto','2012'),
        ('A bela e a Fera','2017'),
		('Duro de matar', '1988'),
        ('Looper: Assassinos do Futuro','2012'),
        ('Batman: O Cavaleiro das Trevas Ressurge','2012'),
        ('Trapaça','2013'),
        ('Jogos Vorazes','2012'),
        ('X-Men: Primeira Classe','2011'),
        ('Mad Max: Estrada da Fúria','2015'),
        ('Transformers: Dark of the Moon','2011'),
        ('Transformers','2007'),
        ('Carros','2006'),
        ('Marley & Eu','2008'),
        ('Toy Story','1995'),
        ('Náufrago','2000'),
        ('Forrest Gump: O Contador de Histórias','1994'),
        ('O Expresso Polar','2004'),
        ('A Saga Crepúsculo: Amanhecer - Parte 2','2012'),
        ('Harry Potter e o Cálice de Fogo','2005'),
		('Sr. & Sra. Smith','2005');
-- -------------------------------------------------------


-- --------------------- Tabela ator maior 18 ---------------------
INSERT INTO videotopdb.ator (nome, nomeC, dataNascimento, dataNascimentoC,atorTC) 
VALUES  ('AtorX','C','1973-01-27','C','C'),
        ('AtrizX','C','1990-05-15','C','C');
-- -----------------------------------------------------------------

-- --------------------- Tabela filme maior 18 ---------------------
INSERT INTO videotopdb.filme (titulo,tituloC,ano,anoC,filmeTC)
VALUES 	('Branquinha','C','2016','C','C'),
		('Evil Dead','C','2013','C','C'),
        ('O Jardim de Cimento','C','1993','C','C'),
        ('Bastardos Inglórios','C','2009','C','C');
-- -----------------------------------------------------------------

-- --------------------- Tabela estudio --------------------- 
INSERT INTO videotopdb.estudio (nome,sede)
VALUES ('Warner Bros','Burbank, Califórnia, Estados Unidos'),
	   ('Pixar','Emeryville, Califórnia, Estados Unidos'),
       ('Di Bonaventura Pictures','Los Angeles, Califórnia, Estados Unidos'),
       ('Legendary Pictures','Burbank, Califórnia, Estados Unidos'),
       ('Syncopy','Londres, Inglaterra, Reino Unido'),
       ('The Weinstein Company','Nova Iorque, Estados Unidos'),
       ('Universal Studios','Universal City, Califórnia, Estados Unido'),
       ('Florestal Studios','Florestal, Minas Gerais, Brasil'),
	   ('Fox','Century City, Los Angeles, Estados Unidos');
-- -------------------------------------------------------

-- --------------------- Tabela genero --------------------- 
INSERT INTO videotopdb.genero(nome, descricao)
VALUES ('Ação','Geralmente envolve uma história de protagonistas do bem contra antagonistas do mal, que resolvem suas disputas com o uso de força física, neles o bem sempre prevalece sobre o mal.'),
	   ('Animação','Filme animado (desenho)'),
       ('Romance',' Gênero que pode se definido como aquele cujo enredo se desenvolve em torno de um envolvimento amoroso entre os protagonistas.'),
       ('Fantasia','Gênero da ficção em que se usa geralmente fenômenos sobrenaturais, mágicos e outros como um elemento primário do enredo, tema ou configuração.'),
       ('Aventura','Gênero cinematográfico que reflete um mundo heroico de combates e aventuras.'),
       ('Comédia','Gênero que faz uso do humor.'),
       ('Erótico','O cinema erótico é um género de cinema semelhante ao pornográfico.'),
       ('Terror','Terror ou Horror é um género de filmes que procura uma reação emocional negativa dos espectadores, ao jogar com os medos primários da audiência.'),
       ('Drama','Qualquer narrativa no âmbito da prosa literária em que haja conflito ou atrito.');
-- -------------------------------------------------------      


-- --------------------- Tabela filme_tem_ator --------------------- 
INSERT INTO videotopdb.filme_tem_ator
VALUES (1,'U',1,'U','Harry Potter', 'U','U'),
	   (1,'U',2,'U','Hermione Granger', 'U','U'),
       (1,'U',3,'U','Ronald Weasley', 'U','U'),
       (1,'U',5,'U','Severo Snape', 'U','U'),
       (1,'U',17,'U','Albus Percival Wulfric Brian Dumbledore', 'U','U'),
       (2,'U',1,'U','Arthur Kipp', 'U','U'),
       (3,'U',2,'U','Bela', 'U','U'),
       (4,'U',6,'U','Detetive John McClane', 'U','U'),
       (4,'U',5,'U','Hans Gruber', 'U','U'),
       (5,'U',6,'U','Joe', 'U','U'),
       (5,'U',7,'U','Joe', 'U','U'),
       (6,'U',7,'U','Robin John Blake', 'U','U'),
       (6,'U',8,'U','Bruce Wayne', 'U','U'),
       (7,'U',8,'U','Irving Rosenfeld', 'U','U'),
       (7,'U',9,'U','Rosalyn Rosenfeld', 'U','U'),
       (8,'U',9,'U','Katniss Everdeen', 'U','U'),
       (9,'U',9,'U','Mística', 'U','U'),
       (9,'U',10,'U','Charles Xavier', 'U','U'),
       (9,'U',11,'U','Magneto', 'U','U'),
       (9,'U',12,'U','Fera', 'U','U'),
       (10,'U',13,'U','Nux', 'U','U'),
       (10,'U',14,'U','The Splendid Angharad', 'U','U'),
       (11,'U',13,'U','Carly', 'U','U'),
       (11,'U',14,'U','Sam Witwicky', 'U','U'),
       (12,'U',14,'U','Sam Witwicky', 'U','U'),
       (13,'U',15,'U','Voz do Relâmpago McQueen', 'U','U'),
       (14,'U',15,'U','John Grogan', 'U','U'),
       (15,'U',16,'U','Voz do Woody', 'U','U'),
       (16,'U',16,'U','Chuck Noland', 'U','U'),
       (17,'U',16,'U','Forrest Gump', 'U','U'),
       (18,'U',16,'U','Condutor, o Vagabundo e Papai Noel', 'U','U'),
       (20,'U',1,'U','Harry Potter', 'U','U'),
	   (20,'U',2,'U','Hermione Granger', 'U','U'),
       (20,'U',3,'U','Ronald Weasley', 'U','U'),
       (20,'U',4,'U','Trouxa', 'U','U'),
       (20,'U',5,'U','Severo Snape', 'U','U'),
       (20,'U',18,'U','Albus Percival Wulfric Brian Dumbledore', 'U','U'),
       (21,'U',21,'U','Branquinha', 'C','C'),
       (22,'U',20,'U','Ash Williams', 'C','C'),
       (23,'U',21,'U','Julie', 'C','C'),
       (24,'U',21,'U','Ten. Aldo Raine', 'C','C'),
       (25,'U',21,'U','John Smith', 'C','C');
-- -------------------------------------------------------          
       
       
-- --------------------- Tabela filme_tem_genero --------------------- 
INSERT INTO videotopdb.filme_tem_genero
VALUES (1,'U',4,'U'),
	   (2,'U',8,'U'),
       (2,'U',9,'U'),
       (3,'U',3,'U'),
       (3,'U',4,'U'),
       (4,'U',1,'U'),
       (5,'U',1,'U'),
       (6,'U',1,'U'),
       (6,'U',5,'U'),
       (7,'U',6,'U'),
       (7,'U',9,'U'),
       (8,'U',3,'U'),
       (8,'U',4,'U'),
       (8,'U',5,'U'),
       (8,'U',9,'U'),
       (9,'U',1,'U'),
       (10,'U',1,'U'),
       (11,'U',1,'U'),
       (12,'U',1,'U'),
       (13,'U',2,'U'),
       (13,'U',5,'U'),
       (13,'U',6,'U'),
       (14,'U',6,'U'),
       (15,'U',2,'U'),
       (15,'U',6,'U'),
       (16,'U',3,'U'),
       (16,'U',9,'U'),
       (17,'U',3,'U'),
       (17,'U',9,'U'),
       (18,'U',4,'U'),
       (18,'U',9,'U'),
       (20,'U',4,'U'),
       (21,'U',7,'U'),
       (22,'U',8,'U'),
       (23,'U',7,'U'),
       (23,'U',8,'U'),
       (24,'U',1,'U'),
       (24,'U',9,'U'),
       (25,'U',1,'U'),
       (25,'U',3,'U'),
       (25,'U',6,'U');
-- -------------------------------------------------------          
       

-- --------------------- Tabela filme_tem_estudio --------------------- 
INSERT INTO videotopdb.filme_tem_estudio
VALUES (1,'U',1,'U'),
	   (2,'U',8,'U'),
       (3,'U',8,'U'),
       (4,'U',9,'U'),
       (5,'U',8,'U'),
       (6,'U',4,'U'),
       (6,'U',5,'U'),
       (7,'U',8,'U'),
       (8,'U',8,'U'),
       (9,'U',9,'U'),
       (10,'U',1,'U'),
       (11,'U',3,'U'),
       (12,'U',3,'U'),
       (13,'U',2,'U'),
       (14,'U',9,'U'),
       (15,'U',2,'U'),
       (16,'U',9,'U'),
       (17,'U',8,'U'),
       (20,'U',1,'U'),
       (21,'U',8,'U'),
       (22,'U',8,'U'),
       (23,'U',8,'U'),
       (24,'U',7,'U'),
       (24,'U',8,'U'),
       (25,'U',9,'U');
-- -------------------------------------------------------          
       
 INSERT INTO fita (idfilme)
VALUES (1),(1),(1),(1),(1),
       (2),(2),(2),(2),(2),
       (3),(3),(3),(3),(3),
       (4),(4),(4),(4),(4),
       (5),(5),(5),(5),(5),
       (6),(6),(6),(6),(6); 
       
INSERT INTO fita (idfilme)
VALUES (7),(7),(7),(7),(7),
       (8),(8),(8),(8),(8),
       (9),(9),(9),(9),(9),
       (10),(10),(10),(10),(10),
       (11),(11),(11),(11),(11),
       (12),(12),(12),(12),(12),
       (13),(13),(13),(13),(13),
       (14),(14),(14),(14),(14),
       (15),(15),(15),(15),(15),
       (16),(16),(16),(16),(16),
       (17),(17),(17),(17),(17),
       (18),(18),(18),(18),(18),
       (19),(19),(19),(19),(19),
       (20),(20),(20),(20),(20),
       (21),(21),(21),(21),(21),
       (22),(22),(22),(22),(22),
       (23),(23),(23),(23),(23),
       (24),(24),(24),(24),(24),
       (25),(25),(25),(25),(25);


-- --------------------- Tabela tipoUsuario --------------------- 
INSERT INTO videotopdb.tipoUsuario (nome, classe)
VALUES ('Gerente','AS'),
	   ('Atendente','S'),
       ('Titular','C'),
       ('Dependente','C'),
       ('Dependente','U');
-- -------------------------------------------------------
