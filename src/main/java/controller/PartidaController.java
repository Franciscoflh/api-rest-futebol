package controller;

import model.Partida;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PartidaService;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public List<Partida> getAllPartidas() {
        return partidaService.getAllPartidas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> getPartidaById(@PathVariable Long id) {
        Partida partida = partidaService.getPartidaById(id);
        return ResponseEntity.ok(partida);
    }

    @PostMapping
    public ResponseEntity<Partida> createPartida(@RequestBody Partida partida) {
        Partida createdPartida = partidaService.savePartida(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPartida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> updatePartida(@PathVariable Long id, @RequestBody Partida partida) {
        Partida updatedPartida = partidaService.updatePartida(id, partida);
        return ResponseEntity.ok(updatedPartida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartida(@PathVariable Long id) {
        partidaService.deletePartida(id);
        return ResponseEntity.noContent().build();
    }

}