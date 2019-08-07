package br.com.sistema.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.engine.spi.ExecuteUpdateResultCheckStyle;

import br.com.sistema.entity.Cliente;
import br.com.sistema.entity.Procedimento;
import br.com.sistema.entity.Solicitacao;

@Stateless
public class ClienteRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Cliente cadastrarCliente(Cliente c) {
		try{
			this.em.persist(c);
			return c;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cliente excluirCliente(Integer idCliente) {
		try {
			this.em.createQuery("update Cliente set excluido = true where idCliente = :idCliente")
				.setParameter("idCliente", idCliente)
				.executeUpdate();
			Cliente c = this.em.find(Cliente.class, idCliente);
			c.setNomePlano(c.getPlano().getNome());
			c.setPlano(null);
			return c;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Cliente> listarClientes() {
		TypedQuery<Cliente> q = em.createQuery("select new Cliente(c.idCliente, c.dataNascimento, p.nome, c.sexo, c.nome, p.idPlano, c.excluido) "
											 + "from Cliente c left join c.plano p "
											 + "where c.excluido = false", Cliente.class);
		
		return q.getResultList();
	}

	/**
	 * verifica se o beneficiario pode realizar determinado procedimento
	 * @return true se o plano do cliente cobre, false caso contrario
	 */
	public boolean verificaPermissaoParaProcedimento(Integer idCliente, Integer idProcedimento) {
		
		TypedQuery<Long> q = em.createQuery("select count(plano.id) "
												+ "from Plano plano join plano.procedimentos proced "
												+ "join plano.clientes cliente "
												+ "where cliente.id = :idCliente and proced.id = :idProcedimento", Long.class);
		
		q.setParameter("idCliente", idCliente);
		q.setParameter("idProcedimento", idProcedimento);

		Solicitacao p = new Solicitacao();
		p.setAutorizado(!q.getSingleResult().equals(0L));
		
		try {
			p.setCliente(em.find(Cliente.class, idCliente));
			p.setProcedimento(em.find(Procedimento.class, idProcedimento));
			em.persist(p);
		} catch (NullPointerException e) {
			p.setAutorizado(false);
		}


		return p.getAutorizado();
	}

	public Cliente editarCliente(Cliente c) {
		try {
			this.em.createQuery("update Cliente set nome = :nome, plano = :plano, dataNascimento = :dataNascimento, sexo = :sexo where idCliente = :idCliente")
				.setParameter("nome", c.getNome())
				.setParameter("plano", c.getPlano())
				.setParameter("dataNascimento", c.getDataNascimento())
				.setParameter("sexo", c.getSexo())
				.setParameter("idCliente", c.getIdCliente())
				.executeUpdate();
			return c;
		} catch(Exception e) {
			return null;
		}
	}


}
