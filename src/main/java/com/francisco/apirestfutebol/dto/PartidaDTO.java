package com.francisco.apirestfutebol.dto;

import com.francisco.apirestfutebol.model.Partida;
import com.francisco.apirestfutebol.model.Resultado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartidaDTO {

    private Long id;
    private String timeMandante;
    private String timeVisitante;
    private Resultado resultado;

    public PartidaDTO(Long id, String timeMandante, String timeVisitante, Resultado resultado) {
        this.id = id;
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
        this.resultado = resultado;
    }

    public static PartidaDTO fromPartida(Partida partidas){
        return new PartidaDTO(partidas.getId(),
                partidas.getTimeMandante().getNome(),
                partidas.getTimeVisitante().getNome(),
                partidas.getResultado());
    }
}
