package com.mindteck.booksandstuff.rest;

import com.mindteck.booksandstuff.dto.BookDTO;
import com.mindteck.booksandstuff.enitities.user.Role;
import com.mindteck.booksandstuff.enitities.user.User;
import com.mindteck.booksandstuff.rest.exception.MissingRequiredFieldsException;
import com.mindteck.booksandstuff.service.UserService;
import com.mindteck.booksandstuff.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Philip Lozada on 8/14/2017.
 */

@RestController
public class RestClass {

	@Autowired
	UserService userService;

	@Autowired
	BookService bookService;

	@RequestMapping(value="/rest/authenticate",method = RequestMethod.POST,headers="Accept=application/json")
	public ResponseEntity<Role> getRole(@RequestBody User user)  {
		String email = user.getEmail();
		String password = user.getPassword();


		Role role = userService.getRole(email, password);

		if (role == null) {
			throw new MissingRequiredFieldsException("Missing Required Field");
		}else{
			return new ResponseEntity<Role>(role, HttpStatus.OK);
		}

//		Role role = new Role();
//		role.setId(1L);
//		role.setName("AdminNew");
//
//		return new ResponseEntity<>(role, HttpStatus.OK);

	}

	@RequestMapping(value = "/rest/getBook/{bookId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<BookDTO> getBook(@PathVariable("bookId") long bookId) {
		BookDTO book = bookService.getBook(bookId);

		if (book == null) {
			throw new MissingRequiredFieldsException("Missing Required Field");
		} else {
			return new ResponseEntity<>(book, HttpStatus.OK);
		}



	}

}
