package controller;

import model.Estadio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EstadioService;

import java.util.List;

@RestController
@RequestMapping("/estadios")
public class EstadioController {
    private final EstadioService estadioService;

    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @GetMapping
    public List<Estadio> getAllEstadios() {
        return estadioService.getAllEstadios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadio> getEstadioById(@PathVariable Long id) {
        Estadio estadio = estadioService.getEstadioById(id);
        return ResponseEntity.ok(estadio);
    }

    @PostMapping
    public ResponseEntity<Estadio> createEstadio(@RequestBody Estadio estadio) {
        Estadio createdEstadio = estadioService.saveEstadio(estadio);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstadio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estadio> updateEstadio(@PathVariable Long id, @RequestBody Estadio estadio) {
        Estadio updatedEstadio = estadioService.updateEstadio(id, estadio);
        return ResponseEntity.ok(updatedEstadio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadio(@PathVariable Long id) {
        estadioService.deleteEstadio(id);
        return ResponseEntity.noContent().build();
    }
}