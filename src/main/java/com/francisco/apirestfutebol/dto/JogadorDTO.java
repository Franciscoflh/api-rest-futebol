package com.francisco.apirestfutebol.dto;

import com.francisco.apirestfutebol.model.Jogador;
import com.francisco.apirestfutebol.model.Time;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogadorDTO {

    private Long id;

    private String nome;
    private String dataNascimento;
    private double altura;

    private String nomeTime;

    public JogadorDTO(Long id, String nome, String dataNascimento, double altura, Time nomeTime) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.nomeTime = nomeTime.getNome();
    }

    public static JogadorDTO fromJogador(Jogador jogador){
        return new JogadorDTO(jogador.getId(),
                jogador.getNome(),
                jogador.getDataNascimento(),
                jogador.getAltura(),
                jogador.getTime());
    }
}
