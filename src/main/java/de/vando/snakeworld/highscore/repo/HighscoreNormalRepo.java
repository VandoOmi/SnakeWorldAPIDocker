package de.vando.snakeworld.highscore.repo;

import de.vando.snakeworld.highscore.model.HighscoreNormal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HighscoreNormalRepo extends JpaRepository<HighscoreNormal, Integer> {
    HighscoreNormal findTopByOrderByScoreDesc();

    @Query("Select AVG(score) FROM HighscoreNormal")
    int findAvarageOfScore();
}
