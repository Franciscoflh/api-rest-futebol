package service;

import exception.ResourceNotFoundException;
import model.Partida;
import org.springframework.stereotype.Service;
import repository.PartidaRepository;

import java.util.List;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public List<Partida> getAllPartidas() {
        return partidaRepository.findAll();
    }

    public Partida getPartidaById(Long id) {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partida not found with id: " + id));
    }

    public Partida savePartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Partida updatePartida(Long id, Partida updatedPartida) {
        Partida partida = getPartidaById(id);
        partida.setEstadio(updatedPartida.getEstadio());
        partida.setTimeMandante(updatedPartida.getTimeMandante());
        partida.setTimeVisitante(updatedPartida.getTimeVisitante());
        partida.setData(updatedPartida.getData());
        return partidaRepository.save(partida);
    }

    public void deletePartida(Long id) {
        Partida partida = getPartidaById(id);
        partidaRepository.delete(partida);
    }

    public List<Partida> getPartidasByCampeonatoId(Long campeonatoId) {
        return partidaRepository.findByCampeonatoId(campeonatoId);
    }
}

