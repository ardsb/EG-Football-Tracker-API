package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Players")
public class PlayerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    @Column(name = "name")
    private String playerName;

    @Column(name = "age")
    private String playerAge;

    @Column(name = "born")
    private String playerBorn;

    @Column(name = "country")
    private String playerCountry;

    @Column(name = "height")
    private String playerHeight;

    @Column(name = "position")
    private String playerPosition;

    @Column(name = "apps")
    private String playerApps;

    @Column(name = "minutes")
    private String playerPlayedMinutes;

    @Column(name = "goals")
    private String playerGoals;


    @Column(name = "assist")
    private String playerAssist;



    @Column(name = "yellow_card")
    private String playerYellowCard;

    @Column(name = "red_card")
    private String playerRedCard;

    @Column(name = "spg")
    private String playerSpg;

    @Column(name = "ps")
    private String playerPs;

    @Column(name = "won")
    private String playerArialWon;

    @Column(name = "mom")
    private String playerMom;

    @Column(name = "performance")
    private String playerPerformance;


}
