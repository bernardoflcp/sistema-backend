package br.com.sistema.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sistema.entity.Cliente;
import br.com.sistema.service.ClienteService;

@Path("/cliente")
public class ClienteController {
	
	@Inject
	private ClienteService clienteService;
	
	@POST
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente cadastrarCliente(Cliente c) {
			return this.clienteService.cadastrarCliente(c);
	}
	
	@PUT
	@Path("/editar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente editarCliente(Cliente c) {
		Cliente novo = this.clienteService.editarCliente(c);
		
		return novo;
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarClientes() {
		return clienteService.listarClientes();
		//		List<Cliente> clientes = clienteService.listarClientes();
	}
	
	/**
	 * Exclusao logica do cliente
	 * @param idCliente
	 */
	@DELETE
	@Path("/excluir/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente excluirCliente(@PathParam("id") Integer idCliente) {
		return this.clienteService.excluirCliente(idCliente);
	}

	@POST
	@Path("/solicitarProcedimento/{idCliente}/{idProcedimento}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean solicitarProcedimento(@PathParam("idCliente") Integer idCliente, 
										 @PathParam("idProcedimento") Integer idProcedimento) {
		
		return clienteService.solicitarProcedimento(idCliente, idProcedimento);
	}
	
}
