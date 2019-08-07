package br.com.sistema.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.sistema.entity.Plano;
import br.com.sistema.entity.Procedimento;

@Stateless
public class PlanoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Plano cadastrarPlano(Plano p) {
		try{
			this.em.persist(p);
			return p;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean excluirPlano(Integer idPlano) {
		try {
			TypedQuery<Long> query = this.em.createQuery("select count(c.idCliente) from Plano p join p.clientes c where c.excluido = false and p.idPlano = :idPlano", Long.class);
			query.setParameter("idPlano", idPlano);
			
			if(!query.getSingleResult().equals(0L)) {
				return false;
			}
			this.em.createQuery("update Plano p set p.excluido = true where p.idPlano = :idPlano")
				.setParameter("idPlano", idPlano)
				.executeUpdate();
			
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Plano> listarPlanos() {
		try {
			TypedQuery<Plano> q = em.createQuery("select new Plano(p.idPlano, p.nome) from Plano p where p.excluido = false", Plano.class);
			
			return q.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean vincularProcedimento(Integer idPlano, Integer idProcedimento) {
		Procedimento procedimento = this.em.find(Procedimento.class, idProcedimento);
		Plano plano = this.em.find(Plano.class, idPlano);

		if(plano != null && procedimento != null) {
			
			if(plano.getProcedimentos() != null && !plano.getProcedimentos().contains(procedimento)) {
				try {
					plano.getProcedimentos().add(procedimento);
					plano = this.em.merge(plano);
					return true;
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public boolean desvincularProcedimento(Integer idPlano, Integer idProcedimento) {
		Procedimento procedimento = this.em.find(Procedimento.class, idProcedimento);
		Plano plano = this.em.find(Plano.class, idPlano);
		
		if(plano != null && procedimento != null) {
			
			if(plano.getProcedimentos() != null && plano.getProcedimentos().contains(procedimento)) {
				try {
					plano.getProcedimentos().remove(procedimento);
					plano = this.em.merge(plano);
					return true;
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public Plano buscarPlano(Integer idPlano) {
		try {
			TypedQuery<Plano> q = em.createQuery("select new Plano(p.idPlano, p.nome) from Plano p where p.idPlano = :idPlano", Plano.class);
			
			q.setParameter("idPlano", idPlano);
			
			return q.getSingleResult();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
