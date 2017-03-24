package com.person.repository;

import com.person.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user01 on 3/10/17.
 */

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    Person findByName(String name);
}
