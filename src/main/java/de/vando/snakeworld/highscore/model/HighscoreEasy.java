package de.vando.snakeworld.highscore.model;


import jakarta.persistence.*;
import lombok.Data;

@Data

@Entity
@Table
public class HighscoreEasy {

    @Id
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private String name;

}
