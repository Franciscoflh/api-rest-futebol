package com.francisco.apirestfutebol.dto;

import com.francisco.apirestfutebol.model.Time;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeDTO {
    private Long id;
    private String nome;
    private int vitorias;
    private int saldoGols;

    public TimeDTO(Long id, String nome, int vitorias, int saldoGols) {
        this.id = id;
        this.nome = nome;
        this.vitorias = vitorias;
        this.saldoGols = saldoGols;
    }

    public static TimeDTO fromTime(Time time) {
        return new TimeDTO(time.getId(), time.getNome(), time.getVitorias(), time.getSaldoGols());
    }
}
