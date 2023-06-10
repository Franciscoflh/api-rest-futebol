package com.francisco.apirestfutebol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int ano;

    @OneToMany(mappedBy = "campeonato")
    @JsonIgnore
    private List<Time> times;

    @OneToMany(mappedBy = "campeonato")
    @JsonIgnore
    private List<Partida> partidas;
}
