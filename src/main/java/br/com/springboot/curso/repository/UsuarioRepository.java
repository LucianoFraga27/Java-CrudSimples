package br.com.springboot.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso.model.Usuario;

// public interface UsuarioRepository extends JpaRepository<Usuario, Long> Classe Usuario / Tipo da Primary Key

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
