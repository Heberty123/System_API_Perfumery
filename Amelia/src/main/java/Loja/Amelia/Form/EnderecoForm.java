package Loja.Amelia.Form;

import Loja.Amelia.Models.Endereco;
import Loja.Amelia.Models.TipoEntrega;
import lombok.*;
import javax.validation.constraints.*;

@Getter @Setter
@NoArgsConstructor
public class EnderecoForm {

    @NotNull @NotEmpty
    private String rua;
    @NotNull @NotEmpty
    private int numero;

    private String bairro;

    private String cidade;

    private String cep;

    private TipoEntrega tipoEntrega;

    public EnderecoForm(Endereco endereco) {
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.tipoEntrega = endereco.getTipoEntrega();
    }

    public Endereco converter() {
        return new Endereco(this.rua, this.numero, this.bairro, this.cidade, this.cep, this.tipoEntrega);
    }

}
