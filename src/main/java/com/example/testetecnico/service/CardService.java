package com.example.testetecnico.service;

import com.example.testetecnico.model.Card;
import com.example.testetecnico.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> listarCartoes() {
        return cardRepository.findAll();
    }

    public Optional<Card> buscarCartao(Long id) {
        return cardRepository.findById(id);
    }

    public Card salvarCartao(Card card) {
        return cardRepository.save(card);
    }

    public void removerCartao(Long id) {
        cardRepository.deleteById(id);
    }

    public Card ativarOuInativarCartao(Long id, boolean status) {
        Card card = cardRepository.findById(id).orElseThrow();
        card.setStatus(status);
        return cardRepository.save(card);
    }
}


