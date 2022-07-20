package Loja.Amelia.Service.ServiceController.Cliente;

import Loja.Amelia.Dto.ClienteDto;
import Loja.Amelia.Dto.ClienteEnderecoDto;
import Loja.Amelia.Dto.EnderecoDto;
import Loja.Amelia.Exception.ConflictCPFAlreadyExist;
import Loja.Amelia.Models.Cliente;
import Loja.Amelia.Repositories.ClienteRepository;
import Loja.Amelia.Repositories.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@AllArgsConstructor
@ControllerAdvice
public class ClienteCrud {

    private ClienteRepository repCliente;
    private EnderecoRepository repEndereco;
    private ModelMapper modelMapper;

    public ResponseEntity<?> AllClientes(Pageable paginacao){

        Page<Cliente> clientes = repCliente.findAll(paginacao);

        if(clientes.isEmpty())
            return ResponseEntity.notFound().build();

        return new ResponseEntity<>(ClienteDto.Convert(clientes), HttpStatus.OK);
    }


    public ResponseEntity<?> OneClientes(Long id) {

        if(!repCliente.existsById(id))
            return ResponseEntity.notFound().build();


        return new ResponseEntity<>(new ClienteDto(repCliente.findById(id).get()), HttpStatus.OK);
    }


    public ResponseEntity<ClienteDto> Cadastro(ClienteDto clienteDto, UriComponentsBuilder uriBuilder) {


        Cliente cliente = clienteDto.converter();

        if(repCliente.existsByCpf(cliente.getCpf()))
            throw new ConflictCPFAlreadyExist(cliente.getCpf());

        
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


    public ResponseEntity<?> Remover(Long id){

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

    public ResponseEntity ComEndereco(Long id){

        if(!repCliente.existsById(id))
            return ResponseEntity.notFound().build();

        ClienteEnderecoDto clienteEnderecoDto = new ClienteEnderecoDto();
        clienteEnderecoDto.setByClient(repCliente.findById(id).get());
        clienteEnderecoDto.setEnderecos(EnderecoDto.AllEnderecosDto(repEndereco.findByClienteId(id)));




        return ResponseEntity.ok(clienteEnderecoDto);
    }


}
