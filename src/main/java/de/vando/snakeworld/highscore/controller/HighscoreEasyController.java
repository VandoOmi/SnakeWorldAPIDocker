package de.vando.snakeworld.highscore.controller;

import de.vando.snakeworld.highscore.model.HighscoreEasy;
import de.vando.snakeworld.highscore.service.HighscoreEasyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/highscore/leicht")
public class HighscoreEasyController {

    @Autowired
    private HighscoreEasyService service;

    @PostMapping
    public ResponseEntity<HighscoreEasy> addHighscore(@RequestBody HighscoreEasy highscore) {
        return ResponseEntity.ok(service.add(highscore));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<HighscoreEasy> getHighscore(@PathVariable int id) {
        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping("/highest")
    public ResponseEntity<HighscoreEasy> getHighestHighscore() {
        return ResponseEntity.ok(service.readHighset());
    }

    @GetMapping("/average")
    public ResponseEntity<Integer> getAverageHighscore() {
        return ResponseEntity.ok(service.readAverage());
    }

    @GetMapping
    public ResponseEntity<List<HighscoreEasy>> getAllHighscore() {
        return ResponseEntity.ok(service.readAll());
    }


}