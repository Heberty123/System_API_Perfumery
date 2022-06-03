package Loja.Amelia.Form;

import Loja.Amelia.Models.TipoEntrega;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class EnderecoForm {

    @NotNull @NotEmpty
    private String rua;

    private int numero;

    private String bairro;

    private String cidade;

    private String cep;

    private TipoEntrega tipoEntrega;
}
