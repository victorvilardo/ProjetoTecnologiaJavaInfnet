package br.edu.infnet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Solicitante {


	public Solicitante(){

	}

	public Solicitante(Integer id, String nome) {
    }

	public Solicitante(Integer id, String nome, String cpf, String email, Pedido pedido) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.pedido = pedido;
	}
	
    @Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nome")
	private String nome;

	@Column (name = "cpf")
	private String cpf;

	@Column (name = "email")
	private String email;

	@OneToOne
	@JoinColumn (name= "id_pedido")
	private Pedido pedido;

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", nome='" + getNome() + "'" +
			", cpf='" + getCpf() + "'" +
			", email='" + getEmail() + "'" +
			", pedido='" + getPedido() + "'" +
			"}";
	}

}
