package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private PersonRepository repository;

	@PostMapping("/saveCustomer")
	public int saveCustomer(@RequestBody List<Person> persons) {
		repository.saveAll(persons);
		return persons.size();
	}

	@GetMapping("/findAll")
	public Iterable<Person> findAllCustomers() {
		return repository.findAll();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
