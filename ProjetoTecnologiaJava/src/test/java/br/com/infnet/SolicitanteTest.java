package br.com.senac;

import org.junit.jupiter.api.Test;

import br.edu.infnet.domain.Solicitante;

import static org.junit.jupiter.api.Assertions.*;

public class SolicitanteTest {

    @Test
    public void testSolicitanteInstanciaComAtributosCorretos() {
        String expectedNome = "Victor";
        String expectedEmail = "victor@gmail.com";

        Solicitante solicitante = new Solicitante();
        solicitante.setNome(expectedNome);
        solicitante.setEmail(expectedEmail);

        assertEquals(expectedNome, solicitante.getNome());
        assertEquals(expectedEmail, solicitante.getEmail());
    }
}
