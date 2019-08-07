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

import br.com.sistema.entity.Plano;
import br.com.sistema.service.PlanoService;

@Path("/plano")
public class PlanoController {
	
	@Inject
	private PlanoService planoService;
	
	@POST
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Plano cadastrarPlano(Plano p) {
		return this.planoService.cadastrarPlano(p);
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Plano> listarPlanos() {
		return this.planoService.listarPlanos();
	}
	
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean excluirPlano(@PathParam("id") Integer idPlano) {
		return this.planoService.excluirPlano(idPlano);
	}
	
	/**
	 * vincula um procedimento existente a um plano
	 */
	@POST
	@Path("/vincular/{idPlano}/{idProcedimento}")
	@Produces(MediaType.APPLICATION_JSON)
	public String vincularProcedimento(@PathParam("idPlano") Integer idPlano, @PathParam("idProcedimento") Integer idProcedimento) {
			
		if(this.planoService.vincularProcedimento(idPlano, idProcedimento)) {
			return "Procedimento vinculado com sucesso";
		} else {
			return "Erro na operacao";
		}
	}
	
	@POST
	@Path("/desvincular/{idPlano}/{idProcedimento}")
	public String desvincularProcedimento(@PathParam("idPlano") Integer idPlano, @PathParam("idProcedimento") Integer idProcedimento) {
		if(this.planoService.desvincularProcedimento(idPlano, idProcedimento)) {
			return "Procedimento desvinculado com sucesso";
		} else {
			return "Erro na operacao";
		}
	}
	
	@GET
	@Path("/buscarPlano/{idPlano}")
	@Produces(MediaType.APPLICATION_JSON)
	public Plano buscarPlano(@PathParam("idPlano") Integer idPlano) {
		return this.planoService.buscarPlano(idPlano);
	}
	
}
