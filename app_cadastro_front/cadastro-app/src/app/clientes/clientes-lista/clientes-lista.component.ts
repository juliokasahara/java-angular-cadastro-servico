import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrls: ['./clientes-lista.component.css']
})
export class ClientesListaComponent implements OnInit {

  clientes: Cliente[] = [];
  clienteSelecionado: Cliente;
  msgSucesso: string;
  msgErro: string;

  constructor( private service: ClientesService, private router :Router) { }
  
  ngOnInit(): void {
    this.service
      .getClientes()
      .subscribe(response =>{
        this.clientes = response;
      });
  }

  novoCadastro(){
    this.router.navigate(['/clientes/cadastrar']);
  }

  preparaDelecao(cliente: Cliente){
    this.clienteSelecionado = cliente;
  }

  deletarCliente(){
    this.service
        .deletar(this.clienteSelecionado)
        .subscribe( 
          response => {
            this.msgSucesso = 'Deletado com sucesso!'
            this.ngOnInit();
          },
          erro => this.msgErro = 'Ocorreu um erro ao deletar'
        )
  }

}
