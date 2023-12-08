package br.com.senac;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.edu.infnet.controller.ProdutoController;
import br.edu.infnet.service.interfaces.ProdutoService;

import static org.mockito.Mockito.when;


public class ProdutoTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoService;

    private MockMvc mockMvc;

    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();
    }

    @Test
    public void testListaTodosProdutos() throws Exception {
        when(produtoService.buscarTodosProdutos()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/produto/listarprodutos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("produto/listarProdutos"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("produtos"));
    }

    @Test
    public void testCadastrarProdutos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/produto/cadastrar?tipo=SOBREMESA"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("solicitante/cadastrarProdutos"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("produto"));
    }

}
