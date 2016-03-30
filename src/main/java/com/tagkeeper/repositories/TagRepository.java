package com.tagkeeper.repositories;

import com.tagkeeper.entities.Player;
import com.tagkeeper.entities.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon on 2/25/16.
 */
@Repository
public interface TagRepository extends MongoRepository<Tag, Integer>
{

    Tag findByPlayerId(String playerId);

}
