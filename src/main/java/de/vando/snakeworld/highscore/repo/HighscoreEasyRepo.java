package de.vando.snakeworld.highscore.repo;

import de.vando.snakeworld.highscore.model.HighscoreEasy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HighscoreEasyRepo extends JpaRepository<HighscoreEasy, Integer> {
    HighscoreEasy findTopByOrderByScoreDesc();

    @Query("Select AVG(score) FROM HighscoreEasy")
    int findAvarageOfScore();
}
