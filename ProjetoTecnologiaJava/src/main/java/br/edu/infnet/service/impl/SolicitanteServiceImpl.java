package br.edu.infnet.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.stereotype.Service;

import br.edu.infnet.domain.Solicitante;
import br.edu.infnet.exception.SolicitanteException;
import br.edu.infnet.repository.SolicitanteRepository;
import br.edu.infnet.service.interfaces.SolicitanteService;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitanteServiceImpl implements SolicitanteService {

    private final SolicitanteRepository solicitanteRepository;

    @Override
    public Solicitante salvar(Solicitante solicitante) throws SolicitanteException {
 
        return solicitanteRepository.save(solicitante);
    }

    @Override
    public List<Solicitante> buscarTodosSolicitantes() {
        
        return solicitanteRepository.findAll();
    }

    @Override
    public Solicitante buscarPorId(Integer id) throws ObjectNotFoundException {
       
        	Optional<Solicitante> solicitante = solicitanteRepository.findById(id);
		
		return solicitante.orElseThrow(() -> new ObjectNotFoundException("Solicitante não encontrado: " +id ));
    }

    @Override
    public Solicitante salvarSolicitanteAlteracao(Solicitante solicitanteAlterado) throws ObjectNotFoundException {

        Solicitante solicitante = buscarPorId(solicitanteAlterado.getId());
		solicitante.setNome(solicitanteAlterado.getNome());
		solicitante.setCpf(solicitanteAlterado.getCpf());
        solicitante.setEmail(solicitante.getEmail());
		return salvar(solicitante);
    }

    @Override
    public void excluir(Integer id) {
        
         solicitanteRepository.deleteById(id);
    }


    public Map<Integer, Solicitante> criarBancoDeDados() {

        Map<Integer, Solicitante> bancoDeDados = new HashMap<>();

        // Adicionando alguns solicitantes
        bancoDeDados.put(1, new Solicitante(1, "João"));
        bancoDeDados.put(2, new Solicitante(2, "Maria"));
        bancoDeDados.put(3, new Solicitante(3, "Carlos"));

        return bancoDeDados;
    }
    
    
}
