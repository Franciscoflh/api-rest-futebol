package com.francisco.apirestfutebol.service;

import com.francisco.apirestfutebol.dto.TimeDTO;
import com.francisco.apirestfutebol.repository.TimeRepository;
import com.francisco.apirestfutebol.exception.ResourceNotFoundException;
import com.francisco.apirestfutebol.model.Time;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Cacheable("times")
    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

    @Cacheable("times")
    public Time getTimeById(Long id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Time não encontrado com o id: " + id));
    }

    @CacheEvict(value = "times", allEntries = true)
    public Time saveTime(Time time) {
        return timeRepository.save(time);
    }

    @CacheEvict(value = "times", allEntries = true)
    public Time updateTime(Long id, Time updatedTime) {
        Time time = getTimeById(id);
        time.setNome(updatedTime.getNome());
        time.setVitorias(updatedTime.getVitorias());
        time.setSaldoGols(updatedTime.getSaldoGols());
        return timeRepository.save(time);
    }

    public void deleteTime(Long id) {
        Time time = getTimeById(id);
        timeRepository.delete(time);
    }

    public List<TimeDTO> getTimesByCampeonatoId(Long campeonatoId) {
        List<Time> times = timeRepository.findByCampeonatoId(campeonatoId);
        return times.stream().map(TimeDTO::fromTime).collect(Collectors.toList());
    }

    public List<TimeDTO> getTabelaCampeonatoById(Long campeonatoId) {
        List<Time> times = timeRepository.findByCampeonatoId(campeonatoId);
        List<TimeDTO> tabela = new ArrayList<>(times.stream().map(TimeDTO::fromTime).toList());
        tabela.sort(Comparator.comparing(TimeDTO::getVitorias).thenComparing(TimeDTO::getSaldoGols));
        return tabela;
    }
}

