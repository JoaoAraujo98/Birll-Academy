create database projetobirl;

use projetobirl;

create table clientes (

	id BIGINT NOT NULL auto_increment,
    nome varchar (30) not null,
    fone varchar (20) not null,
    cpf varchar (15) not null,
    endereco varchar (30) not null,
    email varchar (30) not null,
    dataNascimento date,
    primary key (id)
    );
    
    




create table mensalidades ( 

	codigo BIGINT NOT NULL auto_increment,
    idcliente BIGINT not null,
    valor double not null,
    datapagamento date,
    datainicio date,
    datafim date,
    primary key (codigo)

);




SELECT * FROM mensalidades WHERE datapagamento
BETWEEN ('2018/02/01') AND ('2018/03/01');
