package br.com.app.controller;

import br.com.app.exception.UsuarioCadastradoException;
import br.com.app.model.Usuario;
import br.com.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService    usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try{
            usuario.setRole("USER");
            usuarioService.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw  new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
