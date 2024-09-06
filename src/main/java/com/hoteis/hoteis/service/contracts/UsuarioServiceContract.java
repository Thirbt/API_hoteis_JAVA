package com.hoteis.hoteis.service.contracts;
import java.util.List;

import com.hoteis.hoteis.models.Usuario;

public interface UsuarioServiceContract {
    List<Usuario> obterTodosusuarios();
    Usuario obterUsuarioPorId(Long id);
    Usuario inserirUsuario(Usuario usuario);
    Usuario editarUsuario(Long id, Usuario usuario);
    void deletarUsuario(Long id);
}
