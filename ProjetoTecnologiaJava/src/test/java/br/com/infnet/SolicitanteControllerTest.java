package br.com.senac;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.edu.infnet.controller.SolicitanteController;
import br.edu.infnet.service.interfaces.SolicitanteService;

import static org.mockito.Mockito.when;

public class SolicitanteControllerTest {

    @InjectMocks
    private SolicitanteController solicitanteController;

    @Mock
    private SolicitanteService solicitanteService;

    private MockMvc mockMvc;

    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(solicitanteController).build();
    }

    @Test
    public void testListarTodosSolicitantes() throws Exception {
        when(solicitanteService.buscarTodosSolicitantes()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/solicitante/listarSolicitantes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("solicitante/listarSolicitantes"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("solicitantes"));
    }

    @Test
    public void testCadastrarSolicitante() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/solicitante/cadastrar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("solicitante/cadastrarSolicitantes"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("solicitantes"));
    }

    @Test
    public void testSalvarSolicitante() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/solicitante/salvar"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("solicitante/listarSolicitantes"));
    }

    // Add more test methods for other controller methods as needed
}
