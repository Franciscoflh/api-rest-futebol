package controller;

import model.Campeonato;
import model.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CampeonatoService;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {
    private final CampeonatoService campeonatoService;

    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @GetMapping
    public List<Campeonato> getAllCampeonatos() {
        return campeonatoService.getAllCampeonatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> getCampeonatoById(@PathVariable Long id) {
        Campeonato campeonato = campeonatoService.getCampeonatoById(id);
        return ResponseEntity.ok(campeonato);
    }

    @PostMapping
    public ResponseEntity<Campeonato> saveCampeonato(@RequestBody Campeonato campeonato) {
        Campeonato createdCampeonato = campeonatoService.saveCampeonato(campeonato);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampeonato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> updateCampeonato(@PathVariable Long id, @RequestBody Campeonato campeonato) {
        Campeonato updatedCampeonato = campeonatoService.updateCampeonato(id, campeonato);
        return ResponseEntity.ok(updatedCampeonato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampeonato(@PathVariable Long id) {
        campeonatoService.deleteCampeonato(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{campeonatoId}/tabela")
    public List<Time> getTabelaCampeonato(@PathVariable Long campeonatoId) {
        return campeonatoService.getTabelaClassificacao(campeonatoId);
    }
}
