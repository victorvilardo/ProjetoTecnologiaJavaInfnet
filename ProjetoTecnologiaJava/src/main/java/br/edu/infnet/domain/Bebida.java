package br.edu.infnet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Bebida extends Produto{
	
	@Column (name = "gelada")
	private boolean gelada;

	@Column (name = "tamanho")
	private float tamanho;
	
	@Column (name = "marca")
	private String marca;
	


	@Override
	public String toString() {
		return "{" +
			" gelada='" + isGelada() + "'" +
			", tamanho='" + getTamanho() + "'" +
			", marca='" + getMarca() + "'" +
			"}";
	}


}
