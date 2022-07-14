package Loja.Amelia.Controllers;

import Loja.Amelia.Dto.EnderecoDto;
import Loja.Amelia.Form.EnderecoForm;
import Loja.Amelia.Models.API.CEP;
import Loja.Amelia.Repositories.EnderecoRepository;
import Loja.Amelia.Service.ServiceController.Endereco.EnderecoCrud;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController @ResponseBody
@AllArgsConstructor @RequestMapping("/Endereco")
public class EnderecoController {

    private EnderecoCrud enderecoCrud;

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<EnderecoDto>> endereco(@PathVariable Long id){

        return enderecoCrud.buscarPeloCliente(id);
    }


    @PostMapping("/cliente/{id}")
    public ResponseEntity<EnderecoForm> Cadastrar(@RequestBody EnderecoForm enderecoForm,
                   @PathVariable Long id, UriComponentsBuilder uri){

        return enderecoCrud.cadastrar(enderecoForm, id, uri);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EnderecoForm> Editar(@RequestBody EnderecoForm enderecoForm,
                   @PathVariable Long id){

        return enderecoCrud.editar(enderecoForm, id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity Remover(@PathVariable Long id){

        return enderecoCrud.remover(id);
    }


    @GetMapping("/cep/{cep}")
    public void ViaCep(@PathVariable Long cep){
        System.out.println("Teste cep: " + cep);

        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);


        RestTemplate restTemplate = new RestTemplate();

        CEP teste = restTemplate.getForObject(url, CEP.class);



        System.out.println(teste);
    }
}
