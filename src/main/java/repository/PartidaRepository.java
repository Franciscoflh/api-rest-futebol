package repository;

import model.Partida;
import model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findByCampeonatoId(Long campeonatoId);
}
