package com.francisco.apirestfutebol.service;

import com.francisco.apirestfutebol.model.Campeonato;
import com.francisco.apirestfutebol.model.Partida;
import com.francisco.apirestfutebol.repository.CampeonatoRepository;
import com.francisco.apirestfutebol.exception.ResourceNotFoundException;
import com.francisco.apirestfutebol.model.Time;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    public CampeonatoService(CampeonatoRepository campeonatoRepository, TimeService timeService, PartidaService partidaService) {
        this.campeonatoRepository = campeonatoRepository;
    }

    public List<Campeonato> getAllCampeonatos() {
        return campeonatoRepository.findAll();
    }

    public Campeonato getCampeonatoById(Long id) {
        return campeonatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campeonato não encontrado com o id: " + id));
    }

    public Campeonato saveCampeonato(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public Campeonato updateCampeonato(Long id, Campeonato updatedCampeonato) {
        Campeonato campeonato = getCampeonatoById(id);
        campeonato.setNome(updatedCampeonato.getNome());

        return campeonatoRepository.save(campeonato);
    }

    public void deleteCampeonato(Long id) {
        Campeonato campeonato = getCampeonatoById(id);
        campeonatoRepository.delete(campeonato);
    }
}

