package com.example.testetecnico.controller;

import com.example.testetecnico.model.User;
import com.example.testetecnico.model.Card;
import com.example.testetecnico.dto.UserDTO;
import com.example.testetecnico.dto.CardDTO;
import com.example.testetecnico.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @PostMapping
    public User criarUsuario(@RequestBody User user) {
        return userService.salvarUsuario(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscarUsuario(@PathVariable Long id) {
        Optional<User> user = userService.buscarUsuario(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizarUsuario(@PathVariable Long id, @RequestBody User user) {
        if (!userService.buscarUsuario(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        return ResponseEntity.ok(userService.salvarUsuario(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
        if (!userService.buscarUsuario(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.removerUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/cartoes")
    public Card adicionarCartao(@PathVariable Long id, @RequestBody Card card) {
        return userService.adicionarCartao(id, card);
    }

    @DeleteMapping("/{id}/cartoes/{cartaoId}")
    public ResponseEntity<Void> removerCartao(@PathVariable Long id, @PathVariable Long cartaoId) {
        userService.removerCartao(id, cartaoId);
        return ResponseEntity.noContent().build();
    }
}


