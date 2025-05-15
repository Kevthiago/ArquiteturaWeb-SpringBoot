package com.aulas.testesunitarios;

import com.aulas.testesunitarios.service.UsuarioService;
import com.aulas.testesunitarios.model.Usuario;
import com.aulas.testesunitarios.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    private UsuarioRepository repository;
    private UsuarioService service;

    @BeforeEach
    void setUp() {
        repository = mock(UsuarioRepository.class);
        service = new UsuarioService(repository);
    }

    @Test
    void testListarTodos() {
        Usuario u1 = new Usuario();
        u1.setNome("Ana");
        Usuario u2 = new Usuario();
        u2.setNome("Bruno");

        when(repository.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> lista = service.listarTodos();

        assertEquals(2, lista.size());
        assertEquals("Ana", lista.get(0).getNome());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testBuscarPorId_Existente() {
        Usuario u = new Usuario();
        u.setId(1L);
        u.setNome("Carlos");

        when(repository.findById(1L)).thenReturn(Optional.of(u));

        Optional<Usuario> resultado = service.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Carlos", resultado.get().getNome());
    }

    @Test
    void testBuscarPorId_NaoEncontrado() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        Optional<Usuario> resultado = service.buscarPorId(99L);

        assertFalse(resultado.isPresent());
    }

    @Test
    void testSalvarUsuario() {
        Usuario u = new Usuario();
        u.setNome("Daniela");

        when(repository.save(u)).thenReturn(u);

        Usuario salvo = service.salvar(u);

        assertNotNull(salvo);
        assertEquals("Daniela", salvo.getNome());
        verify(repository, times(1)).save(u);
    }
}
