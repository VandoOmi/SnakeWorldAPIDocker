package de.vando.snakeworld.highscore.controller;

import de.vando.snakeworld.highscore.model.HighscoreHard;
import de.vando.snakeworld.highscore.service.HighscoreHardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/highscore/schwer")
public class HighscoreHardController {

    @Autowired
    private HighscoreHardService service;

    @PostMapping("/add")
    public ResponseEntity<HighscoreHard> addHighscore(@RequestBody HighscoreHard highscore) {
        return ResponseEntity.ok(service.add(highscore));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HighscoreHard> getHighscore(@PathVariable int id) {
        return ResponseEntity.ok(service.read(id));
    }

    @GetMapping("/highest")
    public ResponseEntity<HighscoreHard> getHighestHighscore() {
        return ResponseEntity.ok(service.readHighset());
    }

    @GetMapping("/average")
    public ResponseEntity<Integer> getAverageHighscore() {
        return ResponseEntity.ok(service.readAverage());
    }

    @GetMapping("/all")
    public ResponseEntity<List<HighscoreHard>> getAllHighscore() {
        return ResponseEntity.ok(service.readAll());
    }


}