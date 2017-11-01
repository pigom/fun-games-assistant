package com.pigom.fuga.rest;

import com.pigom.fuga.rest.model.Player;
import com.pigom.fuga.rest.services.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> getPlayers() {
        return new ResponseEntity<>(playerRepository.getPlayers(), HttpStatus.OK);
    }


    @RequestMapping(value = "/player/{id}", method = RequestMethod.POST)
    public ResponseEntity<Player> postPlayer(@RequestBody Player player) {
        playerRepository.addPlayer(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }



}
