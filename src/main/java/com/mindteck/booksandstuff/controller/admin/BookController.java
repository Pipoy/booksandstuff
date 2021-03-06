package com.mindteck.booksandstuff.controller.admin;

import com.mindteck.booksandstuff.controller.LoginController;
import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.enitities.book.Book;
import com.mindteck.booksandstuff.service.CategoryService;
import com.mindteck.booksandstuff.service.book.AuthorService;

import com.mindteck.booksandstuff.service.book.BookService;
import com.mindteck.booksandstuff.service.book.GenreService;
import com.mindteck.booksandstuff.service.book.PublisherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Controller
@RequestMapping("/admin/bookManager")
public class BookController {

	private static final Logger logger = Logger.getLogger(LoginController.class);


	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private GenreService genreService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private CategoryService categoryService;

//	@Autowired
//	BookDAO bookDAO;

	private Path path;


	@GetMapping("/")
	public String listBooks(Model model, HttpSession session) {
		List<Book> books = bookService.getBooks();
		model.addAttribute("booksList", books);

		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			return "admin/bookManager";
		}else {
			return "redirect:/";
		}

	}

	@GetMapping("/bookForm")
	public String showBookForm(Model model, HttpSession session) {
		Book book1 = new Book();

		model.addAttribute("bookShow", book1);

		model.addAttribute("authorsShow",  authorService.getAuthors());
		model.addAttribute("genresShow", genreService.getGenres());
		model.addAttribute("publishersShow", publisherService.getPublishers());
		model.addAttribute("categoriesShow", categoryService.getCategories());

		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			return "admin/formBook";
		}else {
			return "redirect:/";
		}
	}

	@PostMapping("saveBook")
	public String saveBook(@ModelAttribute("bookShow") @Valid BookDTO book,
	                       BindingResult result, Model model, HttpServletRequest request,
	                       HttpSession session) {

		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			if (result.hasErrors()) {
				model.addAttribute("authorsShow", authorService.getAuthors());
				model.addAttribute("genresShow", genreService.getGenres());
				model.addAttribute("publishersShow", publisherService.getPublishers());
				model.addAttribute("categoriesShow", categoryService.getCategories());

				return "admin/formBook";
			}
			MultipartFile productImage = book.getProductImage();
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");
			path = Paths.get(rootDirectory + "\\resources\\images\\" + book.getId() + ".png");

			if (productImage != null && !productImage.isEmpty()) {
				try {
					productImage.transferTo(new File(path.toString()));
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("Product image saving failed!,", e);
				}
			}
			bookService.add(book);



		}else {
			return "redirect:/";
		}
		return "redirect:/admin/bookManager/";
	}


	@GetMapping("/updateFormBook")
	public String updateForm(@RequestParam("bookId") String theId, Model model, HttpSession session) {

		Long roleId = (Long) session.getAttribute("userRoleId");
		if (roleId==1) {
			BookDTO book = bookService.getBook(Long.parseLong(theId));

			model.addAttribute("authorsShow",  authorService.getAuthors());
			model.addAttribute("genresShow", genreService.getGenres());
			model.addAttribute("publishersShow", publisherService.getPublishers());
			model.addAttribute("categoriesShow", categoryService.getCategories());
			model.addAttribute("bookShow", book);


			return "admin/formBook";
		}else {
			return "redirect:/";
		}
	}

}








