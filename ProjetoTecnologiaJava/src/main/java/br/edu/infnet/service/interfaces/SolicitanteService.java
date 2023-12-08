package br.edu.infnet.service.interfaces;

import java.util.List;
import java.util.Map;

import br.edu.infnet.domain.Solicitante;
import br.edu.infnet.exception.SolicitanteException;
import javassist.tools.rmi.ObjectNotFoundException;

public interface SolicitanteService {

	 Solicitante salvar  (Solicitante solicitante) throws SolicitanteException;
	
	 List<Solicitante> buscarTodosSolicitantes();

	 Solicitante buscarPorId (Integer id) throws ObjectNotFoundException;
	
	 Solicitante salvarSolicitanteAlteracao(Solicitante solicitanteAlterado)throws ObjectNotFoundException;
	
	 void excluir(Integer id);
	
	 Map<Integer, Solicitante> criarBancoDeDados();
    
    
}
