package br.edu.infnet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Sobremesa extends Produto{
	
	@Column (name = "doce")
	private boolean doce;

	@Column (name = "quantidade")
	private float quantidade;

	@Column (name = "informacao")
	private String informacao;


	@Override
	public String toString() {
		return "{" +
			" doce='" + isDoce() + "'" +
			", quantidade='" + getQuantidade() + "'" +
			", informacao='" + getInformacao() + "'" +
			"}";
	}


}
