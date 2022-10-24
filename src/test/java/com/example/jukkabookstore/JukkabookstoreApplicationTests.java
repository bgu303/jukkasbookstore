package com.example.jukkabookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.jukkabookstore.web.BookController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JukkabookstoreApplicationTests {

	@Autowired BookController bookController;
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}

}
