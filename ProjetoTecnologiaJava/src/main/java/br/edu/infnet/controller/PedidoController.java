package br.edu.infnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.domain.Pedido;
import br.edu.infnet.exception.PedidoException;
import br.edu.infnet.service.interfaces.PedidoService;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping ("pedido")
@RequiredArgsConstructor
public class PedidoController {

     private final PedidoService pedidoService;
    
    
    @GetMapping("/listarPedidos")
    public ModelAndView listarTodosPedidos() {
        
        ModelAndView mv = new ModelAndView("pedido/listarPedidos");
        mv.addObject("pedidos", pedidoService.buscarTodosPedidos());
        
        return mv;
        
    }
    
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrarPedido(){
        
        ModelAndView mv = new ModelAndView("pedido/cadastrarPedidos");
        mv.addObject("pedidos", new Pedido());
        return mv;
        
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvarPedido(Pedido pedido) throws PedidoException {
        pedidoService.salvar(pedido);
        return listarTodosPedidos();
        
    }
    
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterarPedido(@PathVariable("id") Integer idPedido) throws ObjectNotFoundException{
        
        ModelAndView mv = new ModelAndView("pedido/alterarPedido");
        mv.addObject("pedidos", pedidoService.buscarPorId(idPedido));
        return mv;
    }
    
    
    @PostMapping("/alterar")
    public ModelAndView salvarPedidoAlteracao(Pedido pedido) throws ObjectNotFoundException {
        
        pedidoService.salvarPedidoAlteracao(pedido);
        return listarTodosPedidos();
        
    }
    
    @GetMapping("/excluir/{id}")
    public ModelAndView excluirPedido(@PathVariable("id") Integer idPedido) throws ObjectNotFoundException{
        
        pedidoService.excluir(idPedido);
        return listarTodosPedidos();
    }

}
