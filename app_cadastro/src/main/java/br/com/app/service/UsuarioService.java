package br.com.app.service;

import br.com.app.dao.UsuarioDAO;
import br.com.app.exception.UsuarioCadastradoException;
import br.com.app.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public Usuario salvar(Usuario usuario){
        boolean exists = usuarioDAO.existsByUsername(usuario.getUsername());
        if(exists){
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return usuarioDAO.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByUsername(username)
                                    .orElseThrow(() -> new UsernameNotFoundException("E-mail não encontrado"));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(usuario.getRole())
                .build();
    }

}
