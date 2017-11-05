package com.pigom.fuga.rest;

import com.pigom.fuga.rest.model.Player;
import com.pigom.fuga.rest.services.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    private SimpMessagingTemplate messageTemplate;

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getPlayers() {
        return new ResponseEntity<>(playerRepository.getPlayers(), HttpStatus.OK);
    }


    @RequestMapping(value = "/player/{id}", method = RequestMethod.POST)
    public ResponseEntity<Player> postPlayer(@RequestBody Player player) {
        playerRepository.addPlayer(player);
        messageTemplate.convertAndSend("/topic/players",
                new ResponseEntity<List<Player>>(playerRepository.getPlayers(), HttpStatus.OK));
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

}
