package com.example.jukkabookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jukkabookstore.domain.Book;
import com.example.jukkabookstore.domain.BookRepository;

@SpringBootApplication
public class JukkabookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JukkabookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book = new Book("Tommin koodausVinkit420", "Tommi K Karppanen", 2022, "AAA-6969", 69.69);
			Book book2 = new Book("Tommin koodausVinkit420", "Tommi K Karppanen", 2022, "AAA-6969", 69.69);
			Book book3 = new Book("Tommin koodausVinkit420", "Tommi K Karppanen", 2022, "AAA-6969", 69.69);
			Book book4 = new Book("Tommin koodausVinkit420", "Tommi K Karppanen", 2022, "AAA-6969", 69.69);
			
			repository.save(book);
			repository.save(book2);
			repository.save(book3);
			repository.save(book4);
		};
	}

}
