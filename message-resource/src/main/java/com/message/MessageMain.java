package com.message;

import com.message.entity.Message;
import com.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableDiscoveryClient
@EnableMongoRepositories
@SpringBootApplication
public class MessageMain {

  @Autowired
  private MessageRepository repository;

  @RequestMapping(value = "/all")
  public List<Message> available() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{type}")
  public Message checkedOut(@PathVariable("type") Message.Type type) {
    return repository.findByType(type);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/create",
          produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Message create(@RequestBody Message message) {
    return repository.save(message);
  }

  public static void main(String[] args) {
    System.setProperty("spring.config.name", "message-server");
    SpringApplication.run(MessageMain.class, args);
  }

  private void deleteRepo() {
    repository.deleteAll();
  }
}
