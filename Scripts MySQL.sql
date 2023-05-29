# criando banco de dados para projeto de PSC
CREATE DATABASE MovieTime;

# usando database criado
USE MovieTime;

# criando tabela usuário
CREATE TABLE Usuario(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	Nome VARCHAR(50),
	Idade INT,
    Genero1 VARCHAR(30),
    Genero2 VARCHAR(30),
    Sexo CHAR (1), # 'M', 'F', 'O'
    Senha VARCHAR(50)
);	

INSERT INTO Usuario 
	(Nome, 
    Idade, 
    Genero1, 
    Genero2, 
    Sexo, 
    Senha)
VALUES
	('Thiago', 
    18, 
    'Ficção-Científica', 
    'Terror', 
    'M', 
    'thiaguin123');
    
    INSERT INTO Usuario 
	(Nome, 
    Idade, 
    Genero1, 
    Genero2, 
    Sexo, 
    Senha)
VALUES
	('Victor', 
    24, 
    'Suspense', 
    'Infantil', 
    'M', 
    'vitin123');


CREATE TABLE Filme (
id INT PRIMARY KEY AUTO_INCREMENT,
id_usuario INT,
titulo VARCHAR(100),
genero VARCHAR(100),
ano INT,
FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

SELECT * FROM Usuario WHERE Nome = 'Victor';

SELECT * FROM Usuario;


