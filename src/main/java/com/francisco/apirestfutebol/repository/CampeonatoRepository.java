package com.francisco.apirestfutebol.repository;

import com.francisco.apirestfutebol.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
}
