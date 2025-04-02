package de.vando.snakeworld.highscore.service;

import de.vando.snakeworld.exceptions.HighscoreAlreadyExistsException;
import de.vando.snakeworld.exceptions.HighscoreNotFoundException;
import de.vando.snakeworld.highscore.model.HighscoreEasy;
import de.vando.snakeworld.highscore.model.HighscoreNormal;
import de.vando.snakeworld.highscore.repo.HighscoreNormalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HighscoreNormalService {

    @Autowired
    private HighscoreNormalRepo repo;

    public HighscoreNormal add(HighscoreNormal highscore) {
        if (repo.findById(highscore.getId()).isPresent()) throw new HighscoreAlreadyExistsException("You can't insert two highscores with the same ID.");
        return repo.save(highscore);
    }

    public HighscoreNormal read(int id) {
        Optional<HighscoreNormal> score = repo.findById(id);
        if (score.isEmpty()) throw new HighscoreNotFoundException("You can't edit a highscore that not exists.");
        return score.get();
    }

    public HighscoreNormal readHighset() {
        return repo.findTopByOrderByScoreDesc();
    }

    public int readAverage() {
        return repo.findAvarageOfScore();
    }

    public List<HighscoreNormal> readAll() {
        return repo.findAll();
    }

}
