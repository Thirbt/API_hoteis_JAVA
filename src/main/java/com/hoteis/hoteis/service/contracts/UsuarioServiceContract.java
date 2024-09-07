package com.hoteis.hoteis.service.contracts;
import java.util.List;

import com.hoteis.hoteis.dto.UsuarioDTO;
import com.hoteis.hoteis.models.Usuario;

public interface UsuarioServiceContract {
    List<Usuario> obterTodosusuarios();
    Usuario obterUsuarioPorId(Long id);
    Usuario inserirUsuario(UsuarioDTO usuarioDTO);
    Usuario editarUsuario(Long id, UsuarioDTO usuarioDTO);
    void deletarUsuario(Long id);
}
