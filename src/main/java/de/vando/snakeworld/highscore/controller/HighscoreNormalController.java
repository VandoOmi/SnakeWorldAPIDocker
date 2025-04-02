package de.vando.snakeworld.highscore.controller;

import de.vando.snakeworld.highscore.model.HighscoreNormal;
import de.vando.snakeworld.highscore.service.HighscoreNormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/highscore/mittel")
public class HighscoreNormalController {

    @Autowired
    private HighscoreNormalService service;

    @PostMapping("/add")
    public ResponseEntity<HighscoreNormal> addHighscore(@RequestBody HighscoreNormal highscore) {
        return ResponseEntity.ok(service.add(highscore));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HighscoreNormal> getHighscore(@PathVariable int id) {
        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping("/highest")
    public ResponseEntity<HighscoreNormal> getHighestHighscore() {
        return ResponseEntity.ok(service.readHighset());
    }

    @GetMapping("/average")
    public ResponseEntity<Integer> getAverageHighscore() {
        return ResponseEntity.ok(service.readAverage());
    }

    @GetMapping("/all")
    public ResponseEntity<List<HighscoreNormal>> getAllHighscore() {
        return ResponseEntity.ok(service.readAll());
    }

}