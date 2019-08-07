package br.com.sistema.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="CLIENTE")
@SequenceGenerator(name = "CLIENTE_ID_SEQ", sequenceName = "CLIENTE_ID_SEQ", allocationSize = 1)
public class Cliente implements Serializable {

	private static final long serialVersionUID = 5163409577388538267L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLIENTE_ID_SEQ")
	@Column(name = "id_pk")
	private Integer idCliente;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_plano_fk")
	private Plano plano;

	@Column
	private Character sexo;
	
	@Column
	private String nome;
	
	@Column
	private Boolean excluido;
	
	@Transient
	private String nomePlano;
	
	@Transient
	private Integer idPlano;

	public Cliente() {}

	//estou usando este idPLano transient para poder buscar o plano na hora de editar o registro la no front.
	public Cliente(Integer idCliente, Date dataNascimento, String nomePlano, Character sexo, String nome, Integer idPlano, Boolean excluido) {
		this.idCliente = idCliente;
		this.dataNascimento = dataNascimento;
		this.nomePlano = nomePlano;
		this.sexo = sexo;
		this.nome = nome;
		this.idPlano = idPlano;
		this.excluido = excluido;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}

	public Integer getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(Integer idPlano) {
		this.idPlano = idPlano;
	}

	public Boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(Boolean excluido) {
		this.excluido = excluido;
	}
}
