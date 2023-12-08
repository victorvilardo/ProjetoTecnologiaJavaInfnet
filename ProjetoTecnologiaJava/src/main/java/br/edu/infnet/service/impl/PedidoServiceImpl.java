package br.edu.infnet.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.domain.Pedido;
import br.edu.infnet.exception.PedidoException;
import br.edu.infnet.repository.PedidoRepository;
import br.edu.infnet.service.interfaces.PedidoService;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido salvar(Pedido pedido) throws PedidoException {

        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> buscarTodosPedidos() {
       
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido buscarPorId(Integer id) throws ObjectNotFoundException {

         Optional<Pedido> pedido = pedidoRepository.findById(id);
        
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado: " +id ));
    }

    @Override
    public Pedido salvarPedidoAlteracao(Pedido pedidoAlterado) throws ObjectNotFoundException {
        
        Pedido pedido = buscarPorId(pedidoAlterado.getId());
        pedido.setWeb(pedidoAlterado.isWeb());
        pedido.setDescricao(pedidoAlterado.getDescricao());
        pedido.setDataPedido(LocalDate.now());
        pedido.setSolicitante(pedidoAlterado.getSolicitante());
        pedido.setProdutos(pedidoAlterado.getProdutos());
        return salvar(pedido);

    }

    @Override
    public void excluir(Integer id) {
        pedidoRepository.deleteById(id);
    }


    

}
