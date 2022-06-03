package Loja.Amelia.Dto;

import Loja.Amelia.Models.TipoEntrega;
import lombok.*;

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


}
