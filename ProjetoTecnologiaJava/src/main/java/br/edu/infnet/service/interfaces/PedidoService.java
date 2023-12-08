package br.edu.infnet.service.interfaces;

import java.util.List;

import br.edu.infnet.domain.Pedido;
import br.edu.infnet.exception.PedidoException;
import javassist.tools.rmi.ObjectNotFoundException;

public interface PedidoService {

     Pedido salvar  (Pedido pedido) throws PedidoException;
	
	 List<Pedido> buscarTodosPedidos();

	 Pedido buscarPorId (Integer id) throws ObjectNotFoundException;
	
	 Pedido salvarPedidoAlteracao(Pedido pedidoAlterado)throws ObjectNotFoundException;
	
	 void excluir(Integer id);

}
