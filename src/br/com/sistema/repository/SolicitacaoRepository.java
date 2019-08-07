package br.com.sistema.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.sistema.entity.Solicitacao;

@Stateless
public class SolicitacaoRepository {
	@PersistenceContext
	private EntityManager em;

	public List<Solicitacao> listarSolicitacoes() {
		TypedQuery<Solicitacao> consulta = em.createQuery("select new Solicitacao(c.nome, p.nome, pl.nome, s.autorizado) from Solicitacao s join s.cliente c join s.procedimento p join c.plano pl", Solicitacao.class);
		return consulta.getResultList();
	}

}
