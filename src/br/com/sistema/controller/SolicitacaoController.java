package br.com.sistema.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sistema.entity.Solicitacao;
import br.com.sistema.service.SolicitacaoService;

@Path("/solicitacao")
public class SolicitacaoController {

	@Inject
	private SolicitacaoService permissaoService;
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Solicitacao> listarSolicitacoes() {
		return permissaoService.listarSolicitacoes();
	}
	
}
