package Loja.Amelia.Service.ServiceController.Endereco;

import Loja.Amelia.Dto.EnderecoDto;
import Loja.Amelia.Form.EnderecoForm;
import Loja.Amelia.Models.Cliente;
import Loja.Amelia.Models.Endereco;
import Loja.Amelia.Repositories.ClienteRepository;
import Loja.Amelia.Repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoCrud {

    private EnderecoRepository endRepository;
    private ClienteRepository cliRepository;

    public ResponseEntity<List<EnderecoDto>> buscarPeloCliente(Long id) {
        List<Endereco> enderecos = endRepository.findByClienteId(id);

        if(!(enderecos.isEmpty())){
            List<EnderecoDto> enderecosDto = EnderecoDto.AllEnderecosDto(enderecos);
            return ResponseEntity.ok().body(enderecosDto);
        }
        return ResponseEntity.notFound().build();
    }



    public ResponseEntity<EnderecoForm> cadastrar(EnderecoForm enderecoForm, Long id, UriComponentsBuilder uriBuilder) {

        Endereco endereco = enderecoForm.converter();
        Optional<Cliente> optional = cliRepository.findById(id);

        if(optional.isEmpty())
            return ResponseEntity.notFound().build();

        endereco.setCliente(optional.get());
        endRepository.save(endereco);

        URI uri = uriBuilder.path("/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(enderecoForm);
    }


    public ResponseEntity<EnderecoForm> editar(EnderecoForm enderecoForm, Long id) {

        Optional<Endereco> optional = endRepository.findById(id);

        if(optional.isEmpty())
            return ResponseEntity.notFound().build();


        Endereco endereco = new Endereco(enderecoForm);
        endereco.setId(id);
        endRepository.save(endereco);

        return ResponseEntity.ok().body(enderecoForm);
    }

    public ResponseEntity remover(Long id) {

        Optional<Endereco> optional = endRepository.findById(id);

        if(optional.isEmpty())
            return ResponseEntity.notFound().build();

        endRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
