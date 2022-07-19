package Loja.Amelia.Dto;

import lombok.Data;
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
}
