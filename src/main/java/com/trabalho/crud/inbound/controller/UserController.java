package com.trabalho.crud.inbound.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.crud.core.dto.UserDto;
import com.trabalho.crud.core.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Animal")
public class UserController {

  private final UserService userService;

   /**
   * busca uma lista com todos os animais.
   * 
   * @return uma lista com todos os animais cadastrados.
   */
  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(userService.findAll());
  }

  /**
   * busca um animal específico pelo ID.
   * 
   * @param id O ID do animal.
   * @return  detalhes do animal
   */
  @GetMapping("/{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

   /**
   * cadastro de um novo animal.
   * 
   * @param userDTO  informações do animal a sererem inseridas.
   * @return  Cadastro do animal criado.
   */
  @PostMapping
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDTO));
  }

  /**
   * atualizar informações de um animal.
   * 
   * @param id O ID do animal que sera atualizado.
   * @param userDTO informações atualizadas do animal.
   * @return informações atualizadas.
   */
  @PutMapping("/{id}")
  public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDTO) {
    return ResponseEntity.ok(userService.update(id, userDTO));
  }

   /**
   * deletar um animal pelo ID.
   * 
   * @param id O ID do animal que será deletado.
   * @return resposta após a exclusão.
   */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
