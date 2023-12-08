package br.edu.infnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.domain.Solicitante;
import br.edu.infnet.exception.SolicitanteException;
import br.edu.infnet.service.interfaces.SolicitanteService;
import javassist.tools.rmi.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping ("solicitante")
@RequiredArgsConstructor
public class SolicitanteController {
    
    private final SolicitanteService solicitanteService;
    
    
    @GetMapping("/listarSolicitantes")
    public ModelAndView listaTodosSolicitantes() {
        
        ModelAndView mv = new ModelAndView("solicitante/listarSolicitantes");
        mv.addObject("solicitantes", solicitanteService.buscarTodosSolicitantes());
        
        return mv;
        
    }
    
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrarSolicitante(){
        
        ModelAndView mv = new ModelAndView("solicitante/cadastrarSolicitantes");
        mv.addObject("solicitantes", new Solicitante());
        return mv;
        
    }
    
    @PostMapping("/salvar")
    public ModelAndView salvarSolicitante(Solicitante solicitante) throws SolicitanteException {
        solicitanteService.salvar(solicitante);
        return listaTodosSolicitantes();
        
    }
    
    
    @GetMapping("/alterar/{id}")
    public ModelAndView alterarSolicitante(@PathVariable("id") Integer idSolicitante) throws ObjectNotFoundException{
        
        ModelAndView mv = new ModelAndView("solicitante/alterarSolicitante");
        mv.addObject("solicitantes", solicitanteService.buscarPorId(idSolicitante));
        return mv;
    }
    
    
    @PostMapping("/alterar")
    public ModelAndView salvarSolicitanteAlteracao(Solicitante solicitante) throws ObjectNotFoundException {
        
        solicitanteService.salvarSolicitanteAlteracao(solicitante);
        return listaTodosSolicitantes();
        
    }
    
    @GetMapping("/excluir/{id}")
    public ModelAndView excluirSolicitante(@PathVariable("id") Integer idSolicitante) throws ObjectNotFoundException{
        
        solicitanteService.excluir(idSolicitante);
        return listaTodosSolicitantes();
    }
    
}
