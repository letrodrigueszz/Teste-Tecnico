package com.example.testetecnico.controller;

import com.example.testetecnico.model.Card;
import com.example.testetecnico.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> listarCartoes() {
        return cardService.listarCartoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> buscarCartao(@PathVariable Long id) {
        Optional<Card> card = cardService.buscarCartao(id);
        return card.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Card criarCartao(@RequestBody Card card) {
        return cardService.salvarCartao(card);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Card> ativarOuInativarCartao(@PathVariable Long id, @RequestParam boolean status) {
        Card card = cardService.ativarOuInativarCartao(id, status);
        return ResponseEntity.ok(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCartao(@PathVariable Long id) {
        cardService.removerCartao(id);
        return ResponseEntity.noContent().build();
    }
}


