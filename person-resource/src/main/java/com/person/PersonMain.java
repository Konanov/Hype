package com.person;

import com.person.entity.Person;
import com.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableDiscoveryClient
@EnableMongoRepositories
@SpringBootApplication
public class PersonMain implements CommandLineRunner {

  @Autowired
  private PersonRepository repository;

  @RequestMapping(value = "/all")
  public List<Person> available() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{name}")
  public Person checkedOut(@PathVariable("name") String name) {
    return repository.findByName(name);
  }

  public static void main(String[] args) {
    System.setProperty("spring.config.name", "person-server");
    SpringApplication.run(PersonMain.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    deleteRepo();
    repository.save(new Person("Петр", "Васильев", Person.Type.REGULAR));
    repository.save(new Person("Валя", "Крутиков", Person.Type.REGULAR));
    repository.save(new Person("Илья", "Лагутенко", Person.Type.POPULAR));
    repository.save(new Person("Владимир", "Путин", Person.Type.GODLIKE));
  }

  private void deleteRepo() {
    repository.deleteAll();
  }
}
