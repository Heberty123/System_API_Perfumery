package Loja.Amelia.Dto;

import Loja.Amelia.Models.Cliente;
import Loja.Amelia.Models.Endereco;
import Loja.Amelia.Models.TipoEntrega;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
public class EnderecoDto {

        private Long id;
        private String rua;
        private int numero;
        private String bairro;
        private String cidade;
        private String cep;
        private TipoEntrega tipoEntrega;


        public EnderecoDto(Endereco endereco) {
                this.id = endereco.getId();
                this.rua = endereco.getRua();
                this.numero = endereco.getNumero();
                this.bairro = endereco.getBairro();
                this.cidade = endereco.getCidade();
                this.cep = endereco.getCep();
                this.tipoEntrega = endereco.getTipoEntrega();
        }


        public static List<EnderecoDto> AllEnderecosDto(List<Endereco> enderecos){
            return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
        }
}
