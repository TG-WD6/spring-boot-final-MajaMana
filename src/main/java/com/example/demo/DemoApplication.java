package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.Pet;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(PetRepository petRepository) {
		return (args) -> {
			// fetch all customers
			log.info("Pets found with findAll():");
			log.info("-------------------------------");
			for (Pet pet : petRepository.findAll()) {
				log.info(pet.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Pet> petById = petRepository.findById(1L);
			log.info("Pet found with findById(1L):");
			log.info("--------------------------------");
			log.info(petById.toString());
			log.info("");

			// fetch customers by last name
			log.info("Pets found with findByUsername('Bobby'):");
			log.info("--------------------------------------------");
			for (Pet pet : petRepository.findByName("Bobby")) {
				log.info(pet.toString());
			}
			log.info("");
		};
	}

	@Bean
	public CommandLineRunner demoCustomer(CustomerRepository customerRepository) {
		return (args) -> {
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Customer> customerById = customerRepository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customerById.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customers found with findByUsername('Jens'):");
			log.info("--------------------------------------------");
			for (Customer customer : customerRepository.findByName("Jens")) {
				log.info(customer.toString());
			}
			log.info("");
		};
	}
}
