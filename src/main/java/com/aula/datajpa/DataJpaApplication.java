package com.aula.datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(DataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return(args) -> {
			//save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			//fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {

				log.info(customer.toString());
			}
			log.info("");

			//fetch individual customer by ID
			Customer customer = repository.findById(5L);
			log.info("Customer found with findById(1L):");
			log.info("---------------------------------");
			log.info(customer.toString());
			log.info("");

			//fetch customers by last name
			log.info("Customer found with findByLastName('Palmer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Palmer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

}