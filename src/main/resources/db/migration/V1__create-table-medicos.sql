create table medicos(

id bigserial,
nome text not null,
telefone text not null,
email text not null unique,
crm text not null unique,
especialidade text not null,
logradouro text not null,
bairro text not null,
cep text not null,
complemento text,
numero text,
uf text not null,
cidade text not null,
CONSTRAINT pk_medicos PRIMARY KEY (id)
);


