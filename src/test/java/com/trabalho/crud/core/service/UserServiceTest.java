package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.User;
import com.trabalho.crud.core.repository.UserRepository;
import com.trabalho.crud.core.dto.UserDto;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @BeforeEach
    void populateRepository() {
        MockitoAnnotations.openMocks(this);
        
        repository.save(User.builder()
                .name("Lilica")
                .species("Cachorro")
                .age(5)
                .ownerName("Thiago")
                .ownerEmail("thiago@email.com")
                .build());
        repository.save(User.builder()
                .name("Luna")
                .species("Gato")
                .age(3)
                .ownerName("Vinicius")
                .ownerEmail("vinicius@email.com")
                .build());
        repository.save(User.builder()
                .name("Pica-pau")
                .species("Pássaro")
                .age(2)
                .ownerName("Mateus")
                .ownerEmail("mateus@email.com")
                .build());
        repository.save(User.builder()
                .name("Toby")
                .species("Cachorro")
                .age(7)
                .ownerName("Carlos")
                .ownerEmail("carlos@email.com")
                .build());
        repository.save(User.builder()
                .name("Nina")
                .species("Gato")
                .age(4)
                .ownerName("Amanda")
                .ownerEmail("amanda@email.com")
                .build());
    }

    @Test
    @DisplayName("Busca todos os usuários")
    void testBuscarTodosOsUsuarios() {
        var allUsers = service.findAll();
        assertEquals(5, allUsers.size());
    }

    @Test
    @DisplayName("Busca um usuário pelo ID")
    void testBuscarUsuarioPorId() {
        User user = repository.findById(1L).orElse(null);
        assertEquals("Lilica", user.getName());
    }

    @Test
    @DisplayName("Cadastro de um novo usuário")
    void testCadastrarUsuario() {
        UserDto newUser = new UserDto("Ralf", "Gato", 7, "Frank", "frank@email.com");
        UserDto createdUser = service.save(newUser);
        
        assertEquals("Ralf", createdUser.getName());
    }

    @Test
    @DisplayName("Atualiza informações de um usuário")
    void testAtualizarUsuario() {
        UserDto updatedUser = new UserDto("Lilica", "Cachorro", 6, "Thiago", "thiago@email.com");
        UserDto result = service.update(1L, updatedUser);
        
        assertEquals(6, result.getAge());
    }

    @Test
    @DisplayName("Deleta um usuário pelo ID")
    void testDeletarUsuario() {
        Long userId = 1L;
        service.deleteById(userId);
        
        // Verifique se o usuário foi realmente deletado
        assertEquals(4, service.findAll().size(), "Deve haver 4 usuários após a exclusão");
    }
}
