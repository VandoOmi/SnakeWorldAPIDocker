package de.vando.snakeworld.highscore.service;

import de.vando.snakeworld.exceptions.HighscoreAlreadyExistsException;
import de.vando.snakeworld.exceptions.HighscoreNotFoundException;
import de.vando.snakeworld.highscore.model.HighscoreEasy;
import de.vando.snakeworld.highscore.model.HighscoreHard;
import de.vando.snakeworld.highscore.repo.HighscoreHardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HighscoreHardService {

    @Autowired
    private HighscoreHardRepo repo;

    public HighscoreHard add(HighscoreHard highscore) {
        if (repo.findById(highscore.getId()).isPresent()) throw new HighscoreAlreadyExistsException("You can't insert two highscores with the same ID.");
        return repo.save(highscore);
    }

    public HighscoreHard read(int id) {
        Optional<HighscoreHard> score = repo.findById(id);
        if (score.isEmpty()) throw new HighscoreNotFoundException("You can't edit a highscore that not exists.");
        return score.get();
    }

    public HighscoreHard readHighset() {
        return repo.findTopByOrderByScoreDesc();
    }

    public int readAverage() {
        return repo.findAvarageOfScore();
    }

    public List<HighscoreHard> readAll() {
        return repo.findAll();
    }

}
