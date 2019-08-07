package br.com.sistema.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.sistema.entity.Procedimento;
import br.com.sistema.repository.ProcedimentoRepository;

public class ProcedimentoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -734468498743427749L;

	@EJB
	private ProcedimentoRepository procedimentoRepository;

	public Procedimento cadastrarProcedimento(Procedimento p) {
		return procedimentoRepository.cadastrarProcedimento(p);
	}
	
	public void excluirProcedimento(Integer idProcedimento) {
		procedimentoRepository.excluirProcedimento(idProcedimento);
	}

	public List<Procedimento> listarProcedimentos() {
		return procedimentoRepository.listarProcedimentos();
	}

	public List<Procedimento> listarProcedimentosPorPlano(Integer idPlano) {
		return procedimentoRepository.listarProcedimentosPorPlano(idPlano);
	}
}
