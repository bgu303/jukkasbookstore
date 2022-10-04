package com.example.jukkabookstore.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jukkabookstore.domain.Book;
import com.example.jukkabookstore.domain.BookRepository;
import com.example.jukkabookstore.domain.CategoryRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@GetMapping("/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}

	@PostMapping("/addbook")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}

	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("book", repository.findById(id));
		return "editbook";
	}

	@GetMapping(value = "/booklistrest")
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	@GetMapping("/booklistrest/{id}")
	public @ResponseBody Book findBookRest(@PathVariable("id") Long id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost() {
		return "login";
	}

}
