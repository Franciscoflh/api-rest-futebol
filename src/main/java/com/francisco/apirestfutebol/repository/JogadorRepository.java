package com.francisco.apirestfutebol.repository;

import com.francisco.apirestfutebol.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
