package com.hoteis.hoteis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoteis.hoteis.dto.UsuarioDTO;
import com.hoteis.hoteis.models.Usuario;
import com.hoteis.hoteis.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario", produces = { "application/json" })
@Tag(name = "Usuários")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @Operation(summary = "Realiza a busca de todos os Usuários", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    public List<Usuario> obterTodosUsuarios() {
        return usuarioService.obterTodosusuarios();
    }

    @GetMapping("{id}")
    @Operation(summary = "Realiza a busca de um Usuário por ID", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public Usuario obterUsuarioPorid(@PathVariable Long id) {
        return usuarioService.obterUsuarioPorId(id);
    }

    @PostMapping
    @Operation(summary = "Realiza a inserção de um Usuário novo", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inserção realizada com sucesso")
    })
    public Usuario inserirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.inserirUsuario(usuarioDTO);
    }

    @PutMapping("{id}")
    @Operation(summary = "Realiza a edição de um Usuário por ID", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Edição realizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.editarUsuario(id, usuarioDTO);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Realiza a deleção de um usuário", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso"),
        @ApiResponse(responseCode = "200", description = "Usuário não encontrado")
    })
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }
}
