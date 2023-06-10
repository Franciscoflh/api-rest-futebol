package com.francisco.apirestfutebol.repository;

import com.francisco.apirestfutebol.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

    @Query("SELECT p FROM Partida p WHERE p.campeonato.id = :campeonatoId AND p.data < CURRENT_TIMESTAMP")
    List<Partida> findPartidasOcorridasByCampeonatoId(@Param("campeonatoId") Long campeonatoId);

    @Query("SELECT p FROM Partida p WHERE p.campeonato.id = :campeonatoId AND p.data >= CURRENT_TIMESTAMP")
    List<Partida> findPartidasNaoOcorridasByCampeonatoId(@Param("campeonatoId") Long campeonatoId);

}
