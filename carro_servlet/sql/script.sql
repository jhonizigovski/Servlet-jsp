create table carro(
	id bigserial not null,
	ativo boolean,
	marca character varying(15),
	nome character varying(20),
	modelo character varying(20),
	cor character varying(20),
	fabricacao date,
	chassi character varying(15),
	constraint carro_pkey primary key (id)
);