package Loja.Amelia.Dto;

import Loja.Amelia.Models.Cliente;
import Loja.Amelia.Models.Endereco;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteEnderecoDto {

    private Long Id;
    private String nome;
    private String cpf;
    private String telefone;
    private String telefone2;
    private String telefone3;

    private List<EnderecoDto> enderecos;

    public void setByClient(Cliente cliente){
        this.setId(cliente.getId());
        this.setNome(cliente.getNome());
        this.setCpf(cliente.getCpf());
        this.setTelefone(cliente.getTelefone());
        this.setTelefone2(cliente.getTelefone2());
        this.setTelefone2(cliente.getTelefone3());
    }

}


