package br.edu.infnet.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Pedido {
	

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;


	@Column (name = "nome")
	private String descricao;

	@Column (name = "dataPedido")
	private LocalDate dataPedido;

	@Column (name = "web")
	private boolean web;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Produto> produtos;

	@OneToOne
	@JoinColumn (name= "id_solicitante")
	private Solicitante solicitante;
	
	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", descricao='" + getDescricao() + "'" +
			", dataPedido='" + getDataPedido() + "'" +
			", web='" + isWeb() + "'" +
			", produtos='" + getProdutos() + "'" +
			", solicitante='" + getSolicitante() + "'" +
			"}";
	}

	

}
