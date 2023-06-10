package com.francisco.apirestfutebol.service;

import com.francisco.apirestfutebol.dto.PartidaDTO;
import com.francisco.apirestfutebol.model.Partida;
import com.francisco.apirestfutebol.repository.PartidaRepository;
import com.francisco.apirestfutebol.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public List<PartidaDTO> getAllPartidas() {
        List<Partida> partidas = partidaRepository.findAll();
        return partidas.stream().map(PartidaDTO::fromPartida).toList();
    }

    public Partida getPartidaById(Long id) {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partida não encontrada com o id: " + id));
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

    public List<Partida> getPartidasOcorridas(Long campeonatoId) {
        return partidaRepository.findPartidasOcorridasByCampeonatoId(campeonatoId);
    }

    public List<Partida> getPartidasNaoOcorridas(Long campeonatoId) {
        return partidaRepository.findPartidasNaoOcorridasByCampeonatoId(campeonatoId);
    }
}

