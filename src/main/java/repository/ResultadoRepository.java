package repository;

import model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}