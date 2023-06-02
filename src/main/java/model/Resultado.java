package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int golsTimeMandante;
    private int golsTimeVisitante;

    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;
}
