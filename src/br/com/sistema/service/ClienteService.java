package br.com.sistema.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import br.com.sistema.entity.Cliente;
import br.com.sistema.repository.ClienteRepository;

public class ClienteService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3281514289538957042L;
	
	@EJB
	private ClienteRepository clienteRepository;

	public Cliente cadastrarCliente(Cliente c) {
		return clienteRepository.cadastrarCliente(c);
	}
	
	public Cliente excluirCliente(Integer idCliente) {
		return clienteRepository.excluirCliente(idCliente);
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.listarClientes();
	}
	
	public Boolean solicitarProcedimento(Integer idCliente, Integer idProcedimento) {
		return this.clienteRepository.verificaPermissaoParaProcedimento(idCliente, idProcedimento);
	}

	public Cliente editarCliente(Cliente c) {
		return this.clienteRepository.editarCliente(c);
	}
	
	
}
