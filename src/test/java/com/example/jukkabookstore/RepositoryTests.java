package com.example.jukkabookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.jukkabookstore.domain.Book;
import com.example.jukkabookstore.domain.BookRepository;
import com.example.jukkabookstore.domain.Category;
import com.example.jukkabookstore.domain.CategoryRepository;
import com.example.jukkabookstore.domain.UserRepository;
import com.example.jukkabookstore.domain.Userr;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createNewBook() {
		Book book = new Book("Jukan kokkivinkit", "Jukka Vesanto", 2022, "AAA-69", 69.69, new Category("Horror"));
		bookRepository.save(book);
		assertThat(book.getAuthor()).isNotNull();
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Novel");
		categoryRepository.save(category);
		assertThat(category.getName()).isNotNull();
	}
	
	@Test
	public void createNewUser() {
		Userr user = new Userr("Jukka", "Salasana", "USER");
		userRepository.save(user);
		assertThat(user.getUsername()).isNotNull();
		
	}
	
	@Test
	public void findByAuthor() {
		List<Book> books = bookRepository.findByAuthor("Jukka Vesanto");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Jukka Vesanto");
		
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = bookRepository.findByAuthor("Jukka Vesanto");
		Book book = books.get(0);
		bookRepository.delete(book);
		List<Book> newBooks = bookRepository.findByAuthor("Jukka Vesanto");
		assertThat(newBooks).hasSize(0);
	}
	
}
