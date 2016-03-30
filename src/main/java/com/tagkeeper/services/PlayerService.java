package com.tagkeeper.services;

import com.tagkeeper.entities.Player;
import com.tagkeeper.entities.Tag;
import com.tagkeeper.repositories.PlayerRepository;
import com.tagkeeper.repositories.TagRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * Created by jon on 2/28/16.
 */
@Service
public class PlayerService
{
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers()
    {
        List<Player> players = playerRepository.findAll();

        return players;
    }

    public Player getPlayer(String id)
    {
        if (isEmpty(id))
        {
            throw new IllegalArgumentException("player ID cannot be null");
        }
        Player player = playerRepository.findOne(id);
        return player;
    }
}
