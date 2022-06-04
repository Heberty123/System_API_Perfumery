package Loja.Amelia.Models;

import Loja.Amelia.Form.EnderecoForm;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private int numero;

    private String bairro;

    private String cidade;

    private String cep;

    private TipoEntrega tipoEntrega;

    @ManyToOne
    private Cliente cliente;


    public Endereco(String rua, int numero, String bairro, String cidade, String cep, TipoEntrega tipoEntrega) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.tipoEntrega = tipoEntrega;
    }

    public Endereco(EnderecoForm enderecoForm) {
        this.rua = enderecoForm.getRua();
        this.numero = enderecoForm.getNumero();
        this.bairro = enderecoForm.getBairro();
        this.cidade = enderecoForm.getCidade();
        this.cep = enderecoForm.getCep();
        this.tipoEntrega = enderecoForm.getTipoEntrega();
    }

}
