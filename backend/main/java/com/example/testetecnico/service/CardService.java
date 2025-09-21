package com.example.testetecnico.service;

import com.example.testetecnico.exception.ResourceNotFoundException;
import com.example.testetecnico.model.Card;
import com.example.testetecnico.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Transactional(readOnly = true)
    public List<Card> listarCartoes() {
        return cardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Card> buscarCartao(Long id) {
        return cardRepository.findById(id);
    }

    @Transactional
    public Card salvarCartao(Card card) {
        return cardRepository.save(card);
    }

    @Transactional
    public void removerCartao(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cartão não encontrado com o id: " + id);
        }
        cardRepository.deleteById(id);
    }

    @Transactional
    public Card ativarOuInativarCartao(Long id, boolean status) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cartão não encontrado com o id: " + id));

        if (card.isStatus() == status) {
        }

        card.setStatus(status);
        return cardRepository.save(card);
    }
}



