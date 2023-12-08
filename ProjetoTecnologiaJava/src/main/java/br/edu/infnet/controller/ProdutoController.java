package br.edu.infnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.domain.Bebida;
import br.edu.infnet.domain.Comida;
import br.edu.infnet.domain.Produto;
import br.edu.infnet.domain.Sobremesa;
import br.edu.infnet.enums.TipoProduto;
import br.edu.infnet.exception.ProdutoException;
import br.edu.infnet.service.interfaces.ProdutoService;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping ("produto")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	
	@GetMapping("/listarprodutos")
	public ModelAndView listaTodosProdutos() {
		
		
		ModelAndView mv = new ModelAndView("produto/listarProdutos");
		
		
		mv.addObject("produtos", produtoService.buscarTodosProdutos());
		
		
		return mv;
		
	}
	
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProdutos(@RequestParam TipoProduto tipo) {
		ModelAndView mv = new ModelAndView("solicitante/cadastrarProdutos");
		
		Produto produto;
		
		switch (tipo) {
			case SOBREMESA:
			produto = new Sobremesa();
			break;
			case COMIDA:
			produto = new Comida();
			break;
			case BEBIDA:
			produto = new Bebida();
			break;
			default:
			throw new IllegalArgumentException("Tipo de produto não reconhecido: " + tipo);
		}
		
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	
	@PostMapping("/salvar")
	public ModelAndView salvarProduto(Produto produto) throws ProdutoException {
		produtoService.salvar(produto);
		
		return listaTodosProdutos();
		
	}
	
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarProduto(@PathVariable("id") Integer idProduto) throws ObjectNotFoundException {
		
		ModelAndView mv = new ModelAndView("produto/alterarProduto");
		
		mv.addObject("produtos", produtoService.buscarPorId(idProduto));
		return mv;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView salvarProdutoAlteracao(Produto produto) throws ObjectNotFoundException  {
		produtoService.salvarProdutoAlteracao(produto);
		
		return listaTodosProdutos();
		
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirProduto(@PathVariable("id") Integer idProduto) {
		
		produtoService.excluir(idProduto);
		return listaTodosProdutos();
	}
	
	
	
}
