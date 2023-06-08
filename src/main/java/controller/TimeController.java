package controller;

import model.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TimeService;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public List<Time> getAllTimes() {
        return timeService.getAllTimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable Long id) {
        Time time = timeService.getTimeById(id);
        return ResponseEntity.ok(time);
    }

    @PostMapping
    public ResponseEntity<Time> createTime(@RequestBody Time time) {
        Time createdTime = timeService.saveTime(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> updateTime(@PathVariable Long id, @RequestBody Time time) {
        Time updatedTime = timeService.updateTime(id, time);
        return ResponseEntity.ok(updatedTime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTime(@PathVariable Long id) {
        timeService.deleteTime(id);
        return ResponseEntity.noContent().build();
    }
}
