package Loja.Amelia.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity @Getter @Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private String telefone;
    private String telefone2;
    private String telefone3;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<Endereco>();
    
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente(){}

    public Cliente(String nome, String cpf, String telefone, String telefone2, String telefone3){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
    }

}
