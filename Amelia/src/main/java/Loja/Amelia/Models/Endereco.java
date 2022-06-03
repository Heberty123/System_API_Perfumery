package Loja.Amelia.Models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty
    private String rua;

    @NotNull @NotEmpty
    private int numero;

    @NotNull @NotEmpty
    private String bairro;

    @NotNull @NotEmpty
    private String cidade;

    @NotNull @NotEmpty
    private String cep;

    private TipoEntrega tipoEntrega;

    @ManyToOne
    private Cliente cliente;


}
