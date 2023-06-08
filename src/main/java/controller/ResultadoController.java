package controller;

import model.Resultado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ResultadoService;

import java.util.List;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {
    private final ResultadoService resultadoService;

    public ResultadoController(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping
    public List<Resultado> getAllResultados() {
        return resultadoService.getAllResultados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> getResultadoById(@PathVariable Long id) {
        Resultado resultado = resultadoService.getResultadoById(id);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Resultado> createResultado(@RequestBody Resultado resultado) {
        Resultado createdResultado = resultadoService.saveResultado(resultado);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResultado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> updateResultado(@PathVariable Long id, @RequestBody Resultado resultado) {
        Resultado updatedResultado = resultadoService.updateResultado(id, resultado);
        return ResponseEntity.ok(updatedResultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultado(@PathVariable Long id) {
        resultadoService.deleteResultado(id);
        return ResponseEntity.noContent().build();
    }
}
