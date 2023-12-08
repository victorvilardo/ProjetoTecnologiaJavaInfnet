package br.edu.infnet.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.edu.infnet.domain.Pedido;
import br.edu.infnet.domain.Solicitante;
import br.edu.infnet.service.interfaces.SolicitanteService;




@Component
public class InitSolicitante implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	SolicitanteService solicitanteService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {


		Solicitante solicitante = new Solicitante(); 
		solicitante.setNome("Victor");
		solicitante.setCpf("12345678");
		solicitante.setEmail("victor@gmail.com");
		
		
		
		List<Solicitante> listaSolicitantes = solicitanteService.buscarTodosSolicitantes();

		listaSolicitantes.stream()
                   .map(Solicitante::getNome)
                   .forEach(System.out::println);
				
			
	
	}

}