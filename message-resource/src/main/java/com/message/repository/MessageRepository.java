package com.message.repository;

import com.message.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by user01 on 3/10/17.
 */

public interface MessageRepository extends MongoRepository<Message, String> {
    Message findByType(Message.Type type);
}
