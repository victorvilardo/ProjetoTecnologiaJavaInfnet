package br.edu.infnet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.infnet.enums.TipoProduto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class Produto {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
    @JoinColumn(name = "pedido_id")  // nome da coluna de chave estrangeira na tabela de Produto
    private Pedido pedido;
	
	@Column (name = "nome")
	private String nome;

	@Column (name = "valor")
	private float valor;

	@Column (name = "codigo")
	private int codigo;

	@Column (name = "tipoProduto")
	private TipoProduto tipoProduto;


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", pedido='" + getPedido() + "'" +
			", nome='" + getNome() + "'" +
			", valor='" + getValor() + "'" +
			", codigo='" + getCodigo() + "'" +
			", tipoProduto='" + getTipoProduto() + "'" +
			"}";
	}


}
