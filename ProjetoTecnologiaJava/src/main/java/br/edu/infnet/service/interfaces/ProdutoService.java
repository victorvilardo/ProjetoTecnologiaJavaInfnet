package br.edu.infnet.service.interfaces;

import java.util.List;

import br.edu.infnet.domain.Produto;
import br.edu.infnet.exception.ProdutoException;
import javassist.tools.rmi.ObjectNotFoundException;

public interface ProdutoService {

     Produto salvar (Produto produto) throws ProdutoException;
	
	 List<Produto> buscarTodosProdutos();

	 Produto buscarPorId (Integer id) throws ObjectNotFoundException;
	
	 Produto salvarProdutoAlteracao(Produto produtoAlterado)throws ObjectNotFoundException;
	
	 void excluir(Integer id);
	
    
}
