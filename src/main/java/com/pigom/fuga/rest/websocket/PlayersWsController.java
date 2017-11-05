package com.pigom.fuga.rest.websocket;

import com.pigom.fuga.rest.model.Player;
import com.pigom.fuga.rest.services.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayersWsController {
    @Autowired
    PlayerRepository playerRepository;

    @MessageMapping("/players")
    @SendTo("/topic/players")
    public ResponseEntity<List<Player>> syncPlayers() {
        return new ResponseEntity<List<Player>>(playerRepository.getPlayers(), HttpStatus.OK);
    }
}
