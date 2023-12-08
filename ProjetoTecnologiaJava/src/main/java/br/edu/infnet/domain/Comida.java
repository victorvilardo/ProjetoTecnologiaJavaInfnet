package br.edu.infnet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Comida extends Produto{
	
	@Column (name = "vegano")
	private boolean vegano;

	@Column (name = "peso")
	private float peso;

	@Column (name = "ingredientes")
	private String ingredientes;


	@Override
	public String toString() {
		return "{" +
			" vegano='" + isVegano() + "'" +
			", peso='" + getPeso() + "'" +
			", ingredientes='" + getIngredientes() + "'" +
			"}";
	}


}
