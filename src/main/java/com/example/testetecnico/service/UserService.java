package com.example.testetecnico.service;

import com.example.testetecnico.model.User;
import com.example.testetecnico.model.Card;
import com.example.testetecnico.repository.UserRepository;
import com.example.testetecnico.repository.CardRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.testetecnico.repository.UserRepository;
import com.example.testetecnico.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CardRepository cardRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }

    public User salvarUsuario(User user) {
        if (user.getSenha() != null && !user.getSenha().startsWith("$2a$")) {
            user.setSenha(passwordEncoder.encode(user.getSenha()));
        }
        return userRepository.save(user);
    }

    public Optional<User> buscarUsuario(Long id) {
        return userRepository.findById(id);
    }

    public void removerUsuario(Long id) {
        userRepository.deleteById(id);
    }

    public Card adicionarCartao(Long userId, Card card) {
        User user = userRepository.findById(userId).orElseThrow();
        card.setUser(user);
        return cardRepository.save(card);
    }

    public void removerCartao(Long userId, Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow();
        if (card.getUser().getId().equals(userId)) {
            cardRepository.delete(card);
        }
    }
}


