package com.francisco.apirestfutebol.repository;

import com.francisco.apirestfutebol.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
    List<Time> findByCampeonatoId(Long campeonatoId);
}
