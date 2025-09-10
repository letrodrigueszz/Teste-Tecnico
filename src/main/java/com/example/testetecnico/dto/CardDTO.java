package com.example.testetecnico.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;

public class CardDTO {
    private Long id;
    @NotNull(message = "numeroCartao é obrigatório")
    private Long numeroCartao;
    @NotBlank(message = "nome é obrigatório")
    private String nome;
    private Boolean status;
    @NotBlank(message = "tipoCartao é obrigatório")
    private String tipoCartao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getNumeroCartao() { return numeroCartao; }
    public void setNumeroCartao(Long numeroCartao) { this.numeroCartao = numeroCartao; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
    public String getTipoCartao() { return tipoCartao; }
    public void setTipoCartao(String tipoCartao) { this.tipoCartao = tipoCartao; }
}


