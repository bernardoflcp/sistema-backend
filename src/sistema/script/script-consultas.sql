select *
from plano_procedimento pp
inner join cliente c on c.id_plano_fk = pp.id_plano_fk_pk
where c.id_pk = 1 and pp.id_procedimento_pk_fk = 3;