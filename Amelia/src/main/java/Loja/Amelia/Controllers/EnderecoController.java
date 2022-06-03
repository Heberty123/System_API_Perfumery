package Loja.Amelia.Controllers;

import Loja.Amelia.Repositories.EnderecoRepository;
import Loja.Amelia.Service.ServiceController.Endereco.EnderecoCrud;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController @ResponseBody
@AllArgsConstructor @RequestMapping("/Endereco")
public class EnderecoController {

    private EnderecoCrud enderecoCrud;

    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> enderero(){

        return crudCliente.AllClientes(paginacao);
    }
}
