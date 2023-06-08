package service;

import exception.ResourceNotFoundException;
import model.Campeonato;
import model.Partida;
import model.Time;
import org.springframework.stereotype.Service;
import repository.CampeonatoRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    private final TimeService timeService;

    private final PartidaService partidaService;

    public CampeonatoService(CampeonatoRepository campeonatoRepository, TimeService timeService, PartidaService partidaService) {
        this.campeonatoRepository = campeonatoRepository;
        this.timeService = timeService;
        this.partidaService = partidaService;
    }

    public List<Time> getTabelaClassificacao(Long campeonatoId) {
        List<Time> times = timeService.getTimesByCampeonatoId(campeonatoId);

        // Atualizar número de vitórias e saldo de gols para cada time
        for (Time time : times) {
            int vitorias = 0;
            int saldoGols = 0;

            List<Partida> partidas = partidaService.getPartidasByCampeonatoId(campeonatoId);

            for (Partida partida : partidas) {
                if (time.getId().equals(partida.getTimeMandante().getId())) {
                    int golsMandante = partida.getResultado().getGolsTimeMandante();
                    int golsVisitante = partida.getResultado().getGolsTimeVisitante();

                    if (golsMandante > golsVisitante) {
                        vitorias++;
                    }
                    saldoGols += (golsMandante - golsVisitante);
                } else if (time.getId().equals(partida.getTimeVisitante().getId())) {
                    int golsMandante = partida.getResultado().getGolsTimeMandante();
                    int golsVisitante = partida.getResultado().getGolsTimeVisitante();

                    if (golsVisitante > golsMandante) {
                        vitorias++;
                    }
                    saldoGols += (golsVisitante - golsMandante);
                }
            }

            time.setVitorias(vitorias);
            time.setSaldoGols(saldoGols);
        }

        times.sort(Comparator.comparingInt(Time::getVitorias).reversed());

        times.sort(Comparator.comparingInt(Time::getSaldoGols).reversed());

        return times;
    }

    public List<Campeonato> getAllCampeonatos() {
        return campeonatoRepository.findAll();
    }

    public Campeonato getCampeonatoById(Long id) {
        return campeonatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campeonato not found with id: " + id));
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

