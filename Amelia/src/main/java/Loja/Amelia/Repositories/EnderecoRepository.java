package Loja.Amelia.Repositories;

import Loja.Amelia.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e FROM Endereco e INNER JOIN e.cliente c WHERE c.id = :id")
    List<Endereco> findByClienteId(@PathParam("id") Long id);
}
