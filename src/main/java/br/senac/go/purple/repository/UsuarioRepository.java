package br.senac.go.purple.repository;

import br.senac.go.purple.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario WHERE email = ?1",
            nativeQuery = true)
    Usuario validateUser(String email);

}
