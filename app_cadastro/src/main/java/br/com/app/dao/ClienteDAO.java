package br.com.app.dao;

import br.com.app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {
}
