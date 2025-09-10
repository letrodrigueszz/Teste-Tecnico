package com.example.testetecnico.model;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeroCartao;
    private String nome;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private TipoCartao tipoCartao;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getNumeroCartao() { return numeroCartao; }
    public void setNumeroCartao(Long numeroCartao) { this.numeroCartao = numeroCartao; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
    public TipoCartao getTipoCartao() { return tipoCartao; }
    public void setTipoCartao(TipoCartao tipoCartao) { this.tipoCartao = tipoCartao; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public enum TipoCartao {
        COMUM, ESTUDANTE, TRABALHADOR
    }
}
