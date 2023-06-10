package com.francisco.apirestfutebol.service;

import com.francisco.apirestfutebol.model.Estadio;
import com.francisco.apirestfutebol.repository.EstadioRepository;
import com.francisco.apirestfutebol.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadioService {
    private final EstadioRepository estadioRepository;

    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    public List<Estadio> getAllEstadios() {
        return estadioRepository.findAll();
    }

    public Estadio getEstadioById(Long id) {
        return estadioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estadio não encontrado com o id: " + id));
    }

    public Estadio saveEstadio(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public Estadio updateEstadio(Long id, Estadio updatedEstadio) {
        Estadio estadio = getEstadioById(id);
        estadio.setNome(updatedEstadio.getNome());
        estadio.setEndereco(updatedEstadio.getEndereco());
        return estadioRepository.save(estadio);
    }

    public void deleteEstadio(Long id) {
        Estadio estadio = getEstadioById(id);
        estadioRepository.delete(estadio);
    }
}

