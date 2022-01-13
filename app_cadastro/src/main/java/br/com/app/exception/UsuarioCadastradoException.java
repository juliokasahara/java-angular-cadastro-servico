package br.com.app.exception;

public class UsuarioCadastradoException extends RuntimeException {

    public UsuarioCadastradoException(String login){
        super("Usuário já cadastrado, login: " + login);
    }
}
