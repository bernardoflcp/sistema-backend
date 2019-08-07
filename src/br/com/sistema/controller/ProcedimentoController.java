package br.com.sistema.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sistema.entity.Procedimento;
import br.com.sistema.service.ProcedimentoService;

@Path("/procedimento")
public class ProcedimentoController {
	
	@Inject
	private ProcedimentoService procedimentoService;
	
	@POST
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Procedimento cadastrarProcedimento(Procedimento p) {
		return this.procedimentoService.cadastrarProcedimento(p);
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Procedimento> listarProcedimentos() {
		return this.procedimentoService.listarProcedimentos();
	}

	@GET
	@Path("/listarPorPlano/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Procedimento> listarProcedimentosPorPlano(@PathParam("id") Integer id) {
		return this.procedimentoService.listarProcedimentosPorPlano(id);
	}

	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void excluirProcedimento(@PathParam("id") Integer idProcedimento) {
		this.procedimentoService.excluirProcedimento(idProcedimento);
	}

}
