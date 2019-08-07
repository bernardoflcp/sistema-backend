package br.com.sistema.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SOLICITACAO")
@SequenceGenerator(name = "SOLICITACAO_ID_SEQ", sequenceName = "SOLICITACAO_ID_SEQ", allocationSize = 1)
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = -8835227349873540513L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SOLICITACAO_ID_SEQ")
	@Column(name="id_pk")
	private Integer id;

	@ManyToOne()
	@JoinColumn(name="id_cliente_fk")
	private Cliente cliente;
	
	@Column
	private Boolean autorizado;
	
	@ManyToOne()
	@JoinColumn(name="id_procedimento_fk")
	private Procedimento procedimento;
	
	@Transient
	private String nomeCliente;
	
	@Transient
	private String nomeProcedimento;
	
	@Transient
	private String nomePlano;
	
	public Solicitacao() {}
	
	public Solicitacao(String nomeCliente, String nomeProcedimento, String nomePlano, boolean autorizado) {
		this.nomeCliente = nomeCliente;
		this.nomeProcedimento = nomeProcedimento;
		this.nomePlano = nomePlano;
		this.autorizado = autorizado;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Boolean getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(Boolean autorizado) {
		this.autorizado = autorizado;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNomeProcedimento() {
		return nomeProcedimento;
	}

	public void setNomeProcedimento(String nomeProcedimento) {
		this.nomeProcedimento = nomeProcedimento;
	}

}
