package com.francisco.apirestfutebol.repository;

import com.francisco.apirestfutebol.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
