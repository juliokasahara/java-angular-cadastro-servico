package br.com.app.dao;

import br.com.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
