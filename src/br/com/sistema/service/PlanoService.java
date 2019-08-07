package br.com.sistema.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.sistema.entity.Plano;
import br.com.sistema.repository.PlanoRepository;

public class PlanoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6753640417117813956L;

	@EJB
	private PlanoRepository planoRepository;

	public Plano cadastrarPlano(Plano p) {
		return planoRepository.cadastrarPlano(p);
	}
	
	public boolean excluirPlano(Integer idPlano) {
		return this.planoRepository.excluirPlano(idPlano);
	}

	public List<Plano> listarPlanos() {
		return planoRepository.listarPlanos();
	}

	public boolean vincularProcedimento(Integer idPlano, Integer idProcedimento) {
		return this.planoRepository.vincularProcedimento(idPlano, idProcedimento);
	}
	
	public boolean desvincularProcedimento(Integer idPlano, Integer idProcedimento) {
		return this.planoRepository.desvincularProcedimento(idPlano, idProcedimento);
	}

	public Plano buscarPlano(Integer idPlano) {
		return this.planoRepository.buscarPlano(idPlano);
	}
}
