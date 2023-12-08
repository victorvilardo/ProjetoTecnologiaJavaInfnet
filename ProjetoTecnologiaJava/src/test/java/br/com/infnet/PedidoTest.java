package br.com.senac;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.edu.infnet.controller.PedidoController;
import br.edu.infnet.service.interfaces.PedidoService;

import static org.mockito.Mockito.when;

public class PedidoTest {

    @InjectMocks
    private PedidoController pedidoController;

    @Mock
    private PedidoService pedidoService;

    private MockMvc mockMvc;

    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(pedidoController).build();
    }

    @Test
    public void testListarTodosPedidos() throws Exception {
        when(pedidoService.buscarTodosPedidos()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/pedido/listarPedidos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("pedido/listarPedidos"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pedidos"));
    }

    @Test
    public void testCadastrarPedido() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pedido/cadastrar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("pedido/cadastrarPedidos"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("pedidos"));
    }

    @Test
    public void testSalvarPedido() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/pedido/salvar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("pedido/listarPedidos"));
    }

    // Add more test methods for other controller methods as needed
}
