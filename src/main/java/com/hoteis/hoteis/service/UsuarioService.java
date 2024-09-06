package com.hoteis.hoteis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoteis.hoteis.exception.NotFoundError;
import com.hoteis.hoteis.models.Usuario;
import com.hoteis.hoteis.repository.UsuarioRepository;
import com.hoteis.hoteis.service.contracts.UsuarioServiceContract;

@Service
public class UsuarioService implements UsuarioServiceContract{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obterTodosusuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obterUsuarioPorId(Long id) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(id);
        if (usuarioEncontrado.isPresent()) {
            return usuarioEncontrado.get();
        } else {
            throw new NotFoundError("Usuário não encontrado com o ID: " + id + " informado");
        }
    }

    @Override
    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario usuario) {
        Usuario usuarioEncontrado = obterUsuarioPorId(id);
        Usuario usuarioEditado = Usuario.builder()
        .id(usuarioEncontrado.getId())
        .nome(usuario.getNome())
        .email(usuario.getEmail())
        .role(usuario.getRole())
        .build();
        return usuarioRepository.save(usuarioEditado);
    }

    @Override
    public void deletarUsuario(Long id) {
        Usuario usuarioEncontrado = obterUsuarioPorId(id);
        usuarioRepository.deleteById(usuarioEncontrado.getId());
    }
}
