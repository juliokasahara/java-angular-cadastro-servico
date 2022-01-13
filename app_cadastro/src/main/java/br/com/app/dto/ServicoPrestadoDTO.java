package br.com.app.dto;

import br.com.app.model.Cliente;
import br.com.app.model.ServicoPrestado;
import br.com.app.util.BigDecimalConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;
    @NotEmpty(message = "{campo.preco.obrigatorio}")
    private String preco;
    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String dataCadastro;
    @NotNull(message = "{campo.cliente.obrigatorio}")
    private Integer idCliente;

    public ServicoPrestado buildServicoPrestado() {

        try {
            LocalDate data = LocalDate.parse(this.dataCadastro, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            ServicoPrestado sp = new ServicoPrestado();
            sp.setDescricao(this.getDescricao());
            sp.setDtaServicoPrestado(data);
            sp.setCliente(new Cliente(this.idCliente));
            sp.setValor(BigDecimalConverter.conveter(this.getPreco()));

            return sp;
        }catch (Throwable e){
            throw e;
        }
    }
}
