package br.com.springboot.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso.model.Usuario;

// public interface UsuarioRepository extends JpaRepository<Usuario, Long> Classe Usuario / Tipo da Primary Key

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "select usuario from Usuario usuario where usuario.nome like %?1%")
	List<Usuario> buscarPorNome(String name);
	
}
