create table cliente (

	codigo bigint(20) primary key auto_increment,
	nome varchar(100),
	data_nascimento date,
	data_cadastro date,
	cpf varchar(11),
	
	email varchar(100),
	celular varchar(15),
	telefone varchar(20),
	
	cep varchar(30),
	logradouro varchar(100),
	numero varchar(30),
	bairro varchar(100),
	complemento varchar(200),
	ponto_referencia varchar(500),
	cidade varchar(30),
	estado varchar(30)
	
)engine=InnoDB default charset=utf8;