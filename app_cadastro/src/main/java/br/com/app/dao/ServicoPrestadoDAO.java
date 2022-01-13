package br.com.app.dao;

import br.com.app.model.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoDAO extends JpaRepository<ServicoPrestado, Integer> {

    @Query(" SELECT s from ServicoPrestado s join s.cliente c where upper( c.nome ) like upper( :nome ) and MONTH(s.dtaServicoPrestado) = :mes ")
    List<ServicoPrestado> findByNomeOuMes(@Param("nome") String nome,@Param("mes") Integer mes);

}
