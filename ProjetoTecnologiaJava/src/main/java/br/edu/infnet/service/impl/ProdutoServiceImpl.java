package br.edu.infnet.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.domain.Produto;
import br.edu.infnet.exception.ProdutoException;
import br.edu.infnet.repository.ProdutoRepository;
import br.edu.infnet.service.interfaces.ProdutoService;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{
    
    private final ProdutoRepository produtoRepository;
    
    @Override
    public Produto salvar(Produto produto) throws ProdutoException {
        
        return produtoRepository.save(produto);
    }
    
    @Override
    public List<Produto> buscarTodosProdutos() {
        
        return produtoRepository.findAll();
    }
    
    @Override
    public Produto buscarPorId(Integer id) throws ObjectNotFoundException {
        
        Optional<Produto> produto = produtoRepository.findById(id);
        
        return produto.orElseThrow(() -> new ObjectNotFoundException("produto não encontrado: " +id ));
    }
    
    @Override
    public Produto salvarProdutoAlteracao(Produto produtoAlterado) throws ObjectNotFoundException {
        
        Produto produto = buscarPorId(produtoAlterado.getId());
        produto.setNome(produtoAlterado.getNome());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setValor(produto.getValor());
        produto.setPedido(produto.getPedido());
        return salvar(produto);
    }
    
    @Override
    public void excluir(Integer id) {
        
        produtoRepository.deleteById(id);
    }
    
    
}
