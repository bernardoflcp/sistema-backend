drop table if exists cliente;
DROP SEQUENCE IF EXISTS cliente_id_seq;
CREATE SEQUENCE cliente_id_seq increment by 1;
create table cliente (
	id_pk int default cliente_id_seq.nextval,
	nome varchar(100),
	data_nascimento date,
	sexo char,
	id_plano_fk int,
	excluido boolean,
	
	PRIMARY KEY (id_pk)
);


drop table if exists plano;
DROP SEQUENCE IF EXISTS plano_id_seq;
CREATE SEQUENCE plano_id_seq increment by 1;
create table plano (
	id_pk int default plano_id_seq.nextval,
	nome varchar(100),
	excluido boolean,
	
	PRIMARY KEY(id_pk)
);


drop table if exists procedimento;
DROP SEQUENCE IF EXISTS procedimento_id_seq;
CREATE SEQUENCE procedimento_id_seq increment by 1;
create table procedimento (
	id_pk int default procedimento_id_seq.nextval,
	nome varchar(100),
	excluido boolean,
	
	PRIMARY KEY (id_pk)
);


drop table if exists plano_procedimento;
create table plano_procedimento(
	id_plano_pk_fk int,
	id_procedimento_pk_fk int,
	
	PRIMARY KEY (id_plano_pk_fk, id_procedimento_pk_fk)
);


drop table if exists solicitacao;
DROP SEQUENCE IF EXISTS solicitacao_id_seq;
CREATE SEQUENCE solicitacao_id_seq increment by 1;

create table solicitacao(
	id_pk int default solicitacao_id_seq.nextval,
	id_cliente_fk int,
	id_procedimento_fk int,
	autorizado boolean,
	PRIMARY KEY (id_pk)
);

alter table cliente add constraint FK_CLIENTE_id_plano foreign key (id_plano_fk)
      references plano(id_pk) on delete restrict on update restrict;

alter table plano_procedimento add constraint FK_PLANO_PROCEDIMENTO_plano_id foreign key (id_plano_pk_fk)
      references plano(id_pk) on delete restrict on update restrict;

alter table plano_procedimento add constraint FK_PLANO_PROCEDIMENTO_proced_id foreign key (id_procedimento_pk_fk)
      references procedimento(id_pk) on delete restrict on update restrict;
      
alter table solicitacao add constraint FK_SOLICITACAO_id_cliente foreign key (id_cliente_fk)
      references cliente(id_pk) on delete restrict on update restrict;
      
alter table solicitacao add constraint FK_SOLICITACAO_id_procedimento foreign key (id_procedimento_fk)
      references procedimento(id_pk) on delete restrict on update restrict;