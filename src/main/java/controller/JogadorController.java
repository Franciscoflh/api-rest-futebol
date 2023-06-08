package controller;

import model.Jogador;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.JogadorService;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public List<Jogador> getAllJogadores() {
        return jogadorService.getAllJogadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> getJogadorById(@PathVariable Long id) {
        Jogador jogador = jogadorService.getJogadorById(id);
        return ResponseEntity.ok(jogador);
    }

    @PostMapping
    public ResponseEntity<Jogador> createJogador(@Validated @RequestBody Jogador jogador) {
        Jogador createdJogador = jogadorService.saveJogador(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJogador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable Long id, @Validated @RequestBody Jogador jogador) {
        Jogador updatedJogador = jogadorService.updateJogador(id, jogador);
        return ResponseEntity.ok(updatedJogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJogador(@PathVariable Long id) {
        jogadorService.deleteJogador(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public Page<Jogador> searchJogadores(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        return jogadorService.searchJogadores(page, size);
    }
}
