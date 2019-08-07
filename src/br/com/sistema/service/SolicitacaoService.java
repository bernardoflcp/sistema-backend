package br.com.sistema.service;

import java.util.List;

import javax.ejb.EJB;

import br.com.sistema.entity.Solicitacao;
import br.com.sistema.repository.SolicitacaoRepository;

public class SolicitacaoService {

	@EJB
	private SolicitacaoRepository permissaoRepository;

	public List<Solicitacao> listarSolicitacoes() {
		return permissaoRepository.listarSolicitacoes();
	}

}
