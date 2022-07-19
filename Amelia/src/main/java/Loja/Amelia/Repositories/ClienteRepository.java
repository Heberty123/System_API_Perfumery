package Loja.Amelia.Repositories;

import Loja.Amelia.Dto.ClienteDto;
import Loja.Amelia.Dto.ClienteEnderecoDto;
import Loja.Amelia.Models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAll(Pageable paginacao);

    boolean existsByCpf(String cpf);

}
