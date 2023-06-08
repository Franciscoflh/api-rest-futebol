package service;

import exception.ResourceNotFoundException;
import model.Estadio;
import org.springframework.stereotype.Service;
import repository.EstadioRepository;

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
                .orElseThrow(() -> new ResourceNotFoundException("Estadio not found with id: " + id));
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

