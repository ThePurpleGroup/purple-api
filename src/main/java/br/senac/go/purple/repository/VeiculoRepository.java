package br.senac.go.purple.repository;

import br.senac.go.purple.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository   extends CrudRepository<Veiculo, Long> {

    @Query(value = "SELECT * FROM veiculo WHERE id_usuario = ?1",
            nativeQuery = true)
    List<Veiculo> findAllBy(Long id_usuario);

}
