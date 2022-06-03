package Loja.Amelia.Dto;

import Loja.Amelia.Models.Cliente;
import Loja.Amelia.Repositories.ClienteRepository;
import Loja.Amelia.Validacao.Constraints.Telefone;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ClienteDto {

    private Long Id;
    @NotNull @NotEmpty
    private String nome;
    @CPF
    private String cpf;
    private String telefone;
    private String telefone2;
    private String telefone3;

    public ClienteDto(){}

    public ClienteDto(Cliente cliente){
        this.Id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.telefone2 = cliente.getTelefone2();
        this.telefone3 = cliente.getTelefone3();
    }

    public static Page<ClienteDto> Convert(Page<Cliente> cliente){
        return cliente.map(ClienteDto::new);
    }


    public Cliente converter() {
        return new Cliente(this.nome, this.cpf, this.telefone, this.telefone2, this.telefone3);
    }
}
