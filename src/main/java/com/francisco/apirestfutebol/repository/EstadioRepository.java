package com.francisco.apirestfutebol.repository;

import com.francisco.apirestfutebol.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<Estadio, Long> {
}
