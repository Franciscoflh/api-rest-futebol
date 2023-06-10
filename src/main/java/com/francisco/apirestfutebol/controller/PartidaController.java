package com.francisco.apirestfutebol.controller;

import com.francisco.apirestfutebol.dto.PartidaDTO;
import com.francisco.apirestfutebol.model.Partida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.francisco.apirestfutebol.service.PartidaService;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public List<PartidaDTO> getAllPartidas() {
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

    @GetMapping("/campeonatos/{campeonatoId}/partidas/ocorridas")
    public List<Partida> getPartidasOcorridas(@PathVariable Long campeonatoId) {
        return partidaService.getPartidasOcorridas(campeonatoId);
    }

    @GetMapping("/campeonatos/{campeonatoId}/partidas/nao-ocorridas")
    public List<Partida> getPartidasNaoOcorridas(@PathVariable Long campeonatoId) {
        return partidaService.getPartidasNaoOcorridas(campeonatoId);
    }
}