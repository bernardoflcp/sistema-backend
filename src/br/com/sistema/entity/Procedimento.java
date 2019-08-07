package br.com.sistema.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="procedimento")
@SequenceGenerator(name = "PROCEDIMENTO_ID_SEQ", sequenceName = "PROCEDIMENTO_ID_SEQ", allocationSize = 1)
public class Procedimento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8187645467808459857L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROCEDIMENTO_ID_SEQ")
	@Column(name="id_pk")
	private Integer id;
	
	private String nome;

	@ManyToMany(mappedBy = "procedimentos")
	private List<Plano> planos;
	
	@Column
	private Boolean excluido = false;
	
	public Procedimento() {}
	
	public Procedimento(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}
	
	
}
