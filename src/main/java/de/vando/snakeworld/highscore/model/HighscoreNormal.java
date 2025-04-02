package de.vando.snakeworld.highscore.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table
public class HighscoreNormal {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private String name;

}
