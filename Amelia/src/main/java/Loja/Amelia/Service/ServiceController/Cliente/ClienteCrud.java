package Loja.Amelia.Service.ServiceController.Cliente;

import Loja.Amelia.Dto.ClienteDto;
import Loja.Amelia.Models.Cliente;
import Loja.Amelia.Repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Service
@AllArgsConstructor
public class ClienteCrud {

    private ClienteRepository repCliente;


    public ResponseEntity<?> AllClientes(Pageable paginacao){

        Page<Cliente> clientes = repCliente.findAll(paginacao);

        if(clientes.isEmpty())
            return ResponseEntity.notFound().build();

        return new ResponseEntity<>(ClienteDto.Convert(clientes), HttpStatus.OK);
    }


    public ResponseEntity<ClienteDto> Cadastro(ClienteDto clienteDto, UriComponentsBuilder uriBuilder){

        Cliente cliente = clienteDto.converter();
        repCliente.save(cliente);

        URI uri = uriBuilder.path("/Cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }


    public ResponseEntity<?> Editar(ClienteDto clienteDto, Long id){

        if(repCliente.findById(id).isPresent()){
            Cliente cliente = clienteDto.converter();
            cliente.setId(id);
            repCliente.save(cliente);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


    public ResponseEntity<?> Remover(@PathVariable Long id){

        if(repCliente.findById(id).isPresent()){
            repCliente.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity RemoverAll(){

        repCliente.deleteAll();
        return ResponseEntity.ok().build();
    }
}
