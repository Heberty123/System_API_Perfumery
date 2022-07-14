package Loja.Amelia.Controllers;

import Loja.Amelia.Dto.ClienteDto;
import Loja.Amelia.Service.ServiceController.Cliente.ClienteCrud;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController @AllArgsConstructor
@ResponseBody @RequestMapping("/Cliente")
public class ClienteController {



    private ClienteCrud crudCliente;


    @GetMapping
    public ResponseEntity<?> clientes(@PageableDefault(sort = "nome", size = 100, direction = Direction.ASC) Pageable paginacao){



        return crudCliente.AllClientes(paginacao);



    }


    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastro(@RequestBody @Valid ClienteDto clienteDto, UriComponentsBuilder uri) {




            return crudCliente.Cadastro(clienteDto, uri);




    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> Editar(@RequestBody @Valid ClienteDto clienteDto, @PathVariable Long id){




        return crudCliente.Editar(clienteDto, id);




    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> Remover(@PathVariable Long id){



        return crudCliente.Remover(id);



    }

    @DeleteMapping("/All")
    @Transactional
    public ResponseEntity RemoverAll(){




        return crudCliente.RemoverAll();




    }


}
