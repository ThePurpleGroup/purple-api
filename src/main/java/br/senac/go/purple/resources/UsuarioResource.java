package br.senac.go.purple.resources;

import br.senac.go.purple.model.Usuario;
import br.senac.go.purple.repository.UsuarioRepository;
import br.senac.go.purple.service.UsuarioService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private final UsuarioRepository usuarioDAO;

    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> obterTodosUsuarios(){

        List<Usuario> usuarios = usuarioService.findAll();
        if(usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id){
        Optional<Usuario> usuario = usuarioDAO.findById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioDAO.save(usuario), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        usuarioDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Usuario usuario){
        usuarioDAO.save(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(path = "/login")
    public ResponseEntity<?> validateUser(@RequestBody Usuario usuario) {
        Usuario user = usuarioDAO.validateUser(usuario.getEmail());

        if (!user.getEmail().isEmpty()) {
            if (user.getSenha().equals(usuario.getSenha())) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}