import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Usuario } from "./usuario";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  email: string;
  flgCadastrar: boolean;
  mensagemSucesso: string;
  errors: String[];

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  onSubmit(){
    this.router.navigate(['/home']);
  }

  preparaCadastrar(event){
    event.preventDefault();
    this.flgCadastrar = true;
  }

  cancelaCadastro(){
    this.flgCadastrar = false;
  }

  cadastrar(){
    const usuario: Usuario = new Usuario();
    usuario.username = this.username;
    usuario.password = this.password;
    usuario.email = this.email;
    this.authService
        .salvar(usuario)
        .subscribe ( response => {
          this.mensagemSucesso = "Cadastro realizado com sucesso! Efetue o login."
        }, errorResponse =>{
          this.mensagemSucesso = null;
          this.errors = errorResponse.error.errors;
          
        })

  }

}
