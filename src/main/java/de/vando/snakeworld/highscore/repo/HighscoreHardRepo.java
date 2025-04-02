package de.vando.snakeworld.highscore.repo;

import de.vando.snakeworld.highscore.model.HighscoreHard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HighscoreHardRepo extends JpaRepository<HighscoreHard, Integer> {
    HighscoreHard findTopByOrderByScoreDesc();

    @Query("Select AVG(score) FROM HighscoreHard")
    int findAvarageOfScore();
}
