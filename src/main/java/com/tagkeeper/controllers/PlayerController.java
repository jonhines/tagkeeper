package com.tagkeeper.controllers;

import com.tagkeeper.entities.Player;
import com.tagkeeper.entities.Tag;
import com.tagkeeper.exceptions.ResourceNotFoundException;
import com.tagkeeper.services.PlayerService;
import com.tagkeeper.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jon on 2/25/16.
 */
@RestController
@RequestMapping("/players")
public class PlayerController
{
    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Player> getAllPlayers()
    {
        List<Player> players = playerService.getAllPlayers();
        return players;
    }

}
