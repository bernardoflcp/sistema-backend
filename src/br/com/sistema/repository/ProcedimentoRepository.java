package br.com.sistema.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.sistema.entity.Procedimento;

@Stateless
public class ProcedimentoRepository {

	@PersistenceContext
	private EntityManager em;

	public Procedimento cadastrarProcedimento(Procedimento p) {
		try {
			this.em.persist(p);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluirProcedimento(Integer idProcedimento) {
		try {
			this.em.createQuery("update Procedimento p set p.excluido = true where p.id = :idProcedimento")
					.setParameter("idPlano", idProcedimento).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Procedimento> listarProcedimentos() {
		try {
			TypedQuery<Procedimento> q = em.createQuery(
					"select new Procedimento(p.id, p.nome) from Procedimento p where p.excluido = false",
					Procedimento.class);

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Procedimento> listarProcedimentosPorPlano(Integer idPlano) {
		try {
			TypedQuery<Procedimento> q = em.createQuery("select new Procedimento(p.id, p.nome) from Procedimento p join p.planos pl "
					+ "where pl.excluido = false and p.excluido = false and pl.id = :idPlano",
					Procedimento.class);
			q.setParameter("idPlano", idPlano);

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
