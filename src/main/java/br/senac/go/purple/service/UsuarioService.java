package br.senac.go.purple.service;

import br.senac.go.purple.model.Usuario;
import br.senac.go.purple.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
