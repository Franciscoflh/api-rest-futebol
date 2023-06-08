package service;

import exception.ResourceNotFoundException;
import model.Time;
import org.springframework.stereotype.Service;
import repository.TimeRepository;

import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

    public Time getTimeById(Long id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Time not found with id: " + id));
    }

    public Time saveTime(Time time) {
        return timeRepository.save(time);
    }

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

    public List<Time> getTimesByCampeonatoId(Long campeonatoId) {
        return timeRepository.findByCampeonatoId(campeonatoId);
    }
}

