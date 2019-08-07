insert into cliente (nome, data_nascimento, sexo) values('Bernardo', '1995-05-08', 'M');
insert into cliente (nome, data_nascimento, sexo) values('Isabelle', '1997-12-22', 'F');

insert into plano (nome) values ('Ouro');
insert into plano (nome) values ('Prata');
insert into plano (nome) values ('Bronze');

insert into procedimento(nome) values ('Ressonancia');
insert into procedimento(nome) values ('Ultrasson');
insert into procedimento(nome) values ('Cintilografia');


insert into plano_procedimento(id_plano_pk_fk, id_procedimento_pk_fk) values (1, 1);
insert into plano_procedimento(id_plano_pk_fk, id_procedimento_pk_fk) values (1, 2);
insert into plano_procedimento(id_plano_pk_fk, id_procedimento_pk_fk) values (1, 3);

insert into plano_procedimento(id_plano_pk_fk, id_procedimento_pk_fk) values (2, 1);
insert into plano_procedimento(id_plano_pk_fk, id_procedimento_pk_fk) values (2, 3);

insert into plano_procedimento(id_plano_pk_fk, id_procedimento_pk_fk) values (3, 2);


1	Ouro
2	Prata
3	Bronze


1	Resson�ncia
2	Ultrasson
3	Cintilografia


update cliente set id_plano_fk = 1 where nome = 'Bernardo';
update cliente set id_plano_fk = 3 where nome = 'Isabelle';


select * 
from plano_procedimento pp
where pp.id_plano_pk_fk = (select id_plano_fk from cliente where id_pk = 4) and pp.id_procedimento_pk_fk = 1;