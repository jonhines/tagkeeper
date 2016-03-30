package com.tagkeeper.repositories;

import com.tagkeeper.entities.Tag;
import com.tagkeeper.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon on 2/25/16.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
