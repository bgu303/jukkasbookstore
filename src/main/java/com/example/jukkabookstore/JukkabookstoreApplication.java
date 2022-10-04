package com.example.jukkabookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jukkabookstore.domain.Book;
import com.example.jukkabookstore.domain.BookRepository;
import com.example.jukkabookstore.domain.Category;
import com.example.jukkabookstore.domain.CategoryRepository;
import com.example.jukkabookstore.domain.UserRepository;
import com.example.jukkabookstore.domain.Userr;

@SpringBootApplication
public class JukkabookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(JukkabookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository, UserRepository uRepository) {
		return (args) -> {
			Category category1 = new Category("Horror");
			Category category2 = new Category("Comedy");
			Category category3 = new Category("Art");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			Book book = new Book("Tommin koodausVinkit420", "Tommi K Karppanen", 2022, "AAA-6969", 69.69, category1);
			Book book2 = new Book("Tommin koodausVinkit421", "Tommi K Karppanen", 2022, "AAA-6969", 69.69, category2);
			Book book3 = new Book("Tommin koodausVinkit422", "Tommi K Karppanen", 2022, "AAA-6969", 69.69, category1);
			Book book4 = new Book("Tommin koodausVinkit423", "Tommi K Karppanen", 2022, "AAA-6969", 69.69, category3);
			Userr user1 = new Userr("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Userr user2 = new Userr("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			
			uRepository.save(user1);
			uRepository.save(user2);

			repository.save(book);
			repository.save(book2);
			repository.save(book3);
			repository.save(book4);
		};
	}

}
