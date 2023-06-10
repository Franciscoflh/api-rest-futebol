package com.francisco.apirestfutebol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int golsTimeMandante;
    private int golsTimeVisitante;

    @OneToOne
    @JoinColumn(name = "partida_id")
    @JsonIgnore
    private Partida partida;
}
