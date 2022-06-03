package Loja.Amelia.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Lob
    private String descricao;

    private String referencia;

    private Long codigoBarra;
    @ManyToOne
    private Marca marca;

    @OneToOne
    private Preco preco;
}
