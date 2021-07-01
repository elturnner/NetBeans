/*Criação do Banco*/
create database autobank
default character set utf8
default collate utf8_general_ci;

/*Criação da Tabela Usuarios*/
create table usuarios(
id int NOT NULL AUTO_INCREMENT,
username varchar(15) NOT NULL,
senha int(15) NOT NULL,
numconta int(9) NOT NULL,
saldoPoup decimal(8, 2),
saldoCor decimal(8, 2),
PRIMARY KEY (id)
) default charset = utf8;

/*Criação do Usuario 01*/
insert into usuarios 
(username, senha, numconta, saldoPoup, saldoCor)
values
('user01', '111', '111', '5000', '2000');

/*Criação do Usuario 02*/
insert into usuarios 
(username, senha, numconta, saldoPoup, saldoCor)
values
('user02', '222', '222', '5000', '2000');