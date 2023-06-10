package com.francisco.apirestfutebol.service;

import com.francisco.apirestfutebol.model.Resultado;
import com.francisco.apirestfutebol.repository.ResultadoRepository;
import com.francisco.apirestfutebol.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoService {

    private final ResultadoRepository resultadoRepository;

    public ResultadoService(ResultadoRepository resultadoRepository){
        this.resultadoRepository = resultadoRepository;
    }

    public List<Resultado> getAllResultados() {
        return resultadoRepository.findAll();
    }

    public Resultado getResultadoById(Long id) {
        return resultadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado não encontrado com o id: " + id));
    }

    public Resultado saveResultado(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    public Resultado updateResultado(Long id, Resultado updatedResultado) {
        Resultado resultado = getResultadoById(id);
        resultado.setGolsTimeMandante(updatedResultado.getGolsTimeMandante());
        resultado.setGolsTimeVisitante(updatedResultado.getGolsTimeVisitante());
        return resultadoRepository.save(resultado);
    }

    public void deleteResultado(Long id) {
        Resultado resultado = getResultadoById(id);
        resultadoRepository.delete(resultado);
    }
}

