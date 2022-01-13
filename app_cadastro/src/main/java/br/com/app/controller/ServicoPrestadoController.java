package br.com.app.controller;

import br.com.app.dao.ClienteDAO;
import br.com.app.dto.ServicoPrestadoDTO;
import br.com.app.dao.ServicoPrestadoDAO;
import br.com.app.model.Cliente;
import br.com.app.model.ServicoPrestado;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ServicoPrestadoDAO servicoPrestadoDAO;
    private final ClienteDAO clienteDAO;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO servicoPrestadoDTO){

        ServicoPrestado servicoPrestado = servicoPrestadoDTO.buildServicoPrestado();

        Cliente cliente = clienteDAO
                                .findById(servicoPrestado.getCliente().getId())
                                .orElseThrow( () ->
                                        new ResponseStatusException(
                                                HttpStatus.BAD_REQUEST, "Não existe.")
                                );

        servicoPrestado.setCliente(cliente);

        return servicoPrestadoDAO.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(@RequestParam(value = "nome", required = false,defaultValue = "") String nome,
                                           @RequestParam(value = "mes", required = false) Integer mes){
        return servicoPrestadoDAO.findByNomeOuMes("%" + nome + "%", mes);
    }

}
