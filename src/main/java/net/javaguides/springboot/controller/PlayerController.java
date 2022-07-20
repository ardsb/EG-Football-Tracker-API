package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.PlayerDetails;
import net.javaguides.springboot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public List<PlayerDetails> getPlayerDetails(){
        return playerRepository.findAll();
    }

    @PostMapping
    public PlayerDetails createPlayer(@RequestBody PlayerDetails user) {
        return playerRepository.save(user);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<PlayerDetails> getPlayerById(@PathVariable  long id){
        PlayerDetails user =  playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id:" + id));
        return ResponseEntity.ok(user);
    }

//
    @PutMapping("{id}")
    public ResponseEntity<PlayerDetails> updateUser(@PathVariable long id, @RequestBody PlayerDetails playerDetails) {
         PlayerDetails updatePlayerDetails = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player Details not exist with id: " + id));

        updatePlayerDetails.setPlayerName(playerDetails.getPlayerName());
        updatePlayerDetails.setPlayerAge(playerDetails.getPlayerAge());
        updatePlayerDetails.setPlayerBorn(playerDetails.getPlayerBorn());
        updatePlayerDetails.setPlayerCountry(playerDetails.getPlayerCountry());
        updatePlayerDetails.setPlayerHeight(playerDetails.getPlayerHeight());
        updatePlayerDetails.setPlayerPosition(playerDetails.getPlayerPosition());
        updatePlayerDetails.setPlayerApps(playerDetails.getPlayerApps());
        updatePlayerDetails.setPlayerPlayedMinutes(playerDetails.getPlayerPlayedMinutes());
        updatePlayerDetails.setPlayerGoals(playerDetails.getPlayerGoals());
        updatePlayerDetails.setPlayerAssist(playerDetails.getPlayerAssist());
        updatePlayerDetails.setPlayerYellowCard(playerDetails.getPlayerYellowCard());
        updatePlayerDetails.setPlayerRedCard(playerDetails.getPlayerRedCard());
        updatePlayerDetails.setPlayerSpg(playerDetails.getPlayerSpg());
        updatePlayerDetails.setPlayerPs(playerDetails.getPlayerPs());
        updatePlayerDetails.setPlayerArialWon(playerDetails.getPlayerArialWon());
        updatePlayerDetails.setPlayerMom(playerDetails.getPlayerMom());
        updatePlayerDetails.setPlayerPerformance(playerDetails.getPlayerPerformance());
        playerRepository.save(updatePlayerDetails);



        return ResponseEntity.ok(updatePlayerDetails);
    }
//
    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){

        PlayerDetails PlayerDetails = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id: " + id));

        playerRepository.delete(PlayerDetails);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
