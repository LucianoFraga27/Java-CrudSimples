package br.com.springboot.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.curso.model.Usuario;
import br.com.springboot.curso.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
   
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	
	/**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/mostranome/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    
    @RequestMapping(value = "/olamundo/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String metdo2(@PathVariable String name) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(name);
    	usuarioRepository.save(usuario);
    	
        return "Ola Mundo " + name + "!";
    }
    
    
    @GetMapping(value = "listatodos")
    @ResponseBody /*Retorna os dados para o corpo da resposta*/
    public ResponseEntity<List<Usuario>> listaUsuario(){
    	List<Usuario> usuarios = usuarioRepository.findAll(); /*Executa consulta no bd*/
    	return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK); /*retorna JSON*/
    }
    
    
    @PostMapping(value = "salvar")
    @ResponseBody /* descricao da resposta */ /*requestbody recebe os dados para salvar*/
    public ResponseEntity<Usuario> salvar (@RequestBody Usuario usuario) {
    	Usuario user = usuarioRepository.save(usuario);
    	return new ResponseEntity<Usuario>(user,HttpStatus.CREATED);
  
    }
    
    @DeleteMapping(value = "delete")
    @ResponseBody 							 /*requestparam pega um parametro*/
    public ResponseEntity<String> delete (@RequestParam Long iduser) {
    	
    	usuarioRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("Usuario deletado",HttpStatus.OK);
  
    }
    
    @GetMapping(value = "buscaruserid")
    @ResponseBody 							 /*requestparam pega um parametro*/
    public ResponseEntity<Usuario> buscaruserid (@RequestParam(name="iduser") Long iduser) {
    	
    	Usuario user = usuarioRepository.findById(iduser).get();
    	
    	return new ResponseEntity<Usuario>(user,HttpStatus.OK);
  
    }
    
    
    
    
    
}
