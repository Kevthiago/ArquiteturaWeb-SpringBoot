package com.aulas.testesunitarios;

import com.aulas.testesunitarios.controller.UsuarioController;
import com.aulas.testesunitarios.model.Usuario;
import com.aulas.testesunitarios.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioControllerTest {

    private UsuarioService usuarioService;
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        usuarioService = mock(UsuarioService.class);
        usuarioController = new UsuarioController(usuarioService);
    }

    @Test
    void testListarUsuarios() {
        Usuario u1 = new Usuario();
        u1.setNome("Ana");
        Usuario u2 = new Usuario();
        u2.setNome("Carlos");

        List<Usuario> usuariosMock = Arrays.asList(u1, u2);

        when(usuarioService.listarTodos()).thenReturn(usuariosMock);

        List<Usuario> resultado = usuarioController.listar();

        assertEquals(2, resultado.size());
        assertEquals("Ana", resultado.get(0).getNome());
    }

    @Test
    void testCriarUsuario() {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome("João");

        when(usuarioService.salvar(any(Usuario.class))).thenReturn(novoUsuario);

        Usuario criado = usuarioController.criar(novoUsuario);

        assertEquals("João", criado.getNome());
        verify(usuarioService).salvar(novoUsuario);
    }

    @Test
    void testBuscarUsuarioExistente() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Maria");

        when(usuarioService.buscarPorId(1L)).thenReturn(Optional.of(usuario));

        ResponseEntity<Usuario> resposta = usuarioController.buscar(1L);

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals("Maria", resposta.getBody().getNome());
    }

    @Test
    void testBuscarUsuarioNaoEncontrado() {
        when(usuarioService.buscarPorId(99L)).thenReturn(Optional.empty());

        ResponseEntity<Usuario> resposta = usuarioController.buscar(99L);

        assertEquals(404, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }
}
