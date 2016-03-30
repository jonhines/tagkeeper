package com.tagkeeper.repositories;

import com.tagkeeper.entities.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon on 2/25/16.
 */
@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

        public Player findByFirstName(String name);
}
