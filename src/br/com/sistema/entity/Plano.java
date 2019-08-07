package br.com.sistema.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLANO")
@SequenceGenerator(name = "PLANO_ID_SEQ", sequenceName = "PLANO_ID_SEQ", allocationSize = 1)
public class Plano implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3569772577010932529L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLANO_ID_SEQ")
	@Column(name = "id_pk")
	private Integer idPlano;

	@Column
	private String nome;

	@OneToMany(mappedBy = "plano", fetch = FetchType.EAGER)
	private List<Cliente> clientes;

	@ManyToMany
	@JoinTable(name="plano_procedimento", joinColumns = @JoinColumn(name="id_plano_pk_fk", referencedColumnName = "id_pk"), inverseJoinColumns = @JoinColumn(name="id_procedimento_pk_fk", referencedColumnName = "id_pk"))
	private List<Procedimento> procedimentos;

	@Column()
	private Boolean excluido = false;

	public Plano() {
		
	}
	
	public Plano(Integer idPlano, String nome) {
		this.idPlano = idPlano;
		this.nome = nome;
	}
	
	public Integer getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Integer idPLano) {
		this.idPlano = idPLano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}
	
	
}
