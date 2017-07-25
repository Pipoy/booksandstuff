package com.mindteck.booksandstuff.service.book.impl;

import com.mindteck.booksandstuff.dao.book.AuthorDAO;
import com.mindteck.booksandstuff.dto.AuthorDTO;
import com.mindteck.booksandstuff.enitities.book.Author;
import com.mindteck.booksandstuff.service.book.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Philip Lozada on 7/25/2017.
 */
@Service
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private AuthorDAO authorDAO;


	@Transactional
	@Override
	public void add(AuthorDTO authorDTO) {
		Author author = new Author();

		author.setId(authorDTO.getId());
		author.setName(authorDTO.getName());

		authorDAO.add(author);
	}

	@Transactional
	@Override
	public AuthorDTO getAuthor(String id) {
		Author author  = authorDAO.getAuthor(Long.parseLong(id));
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(author.getId());
		authorDTO.setName(author.getName());

		return authorDTO;
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getAuthors() {
		List<Author> authors = authorDAO.getAuthors();
		Map<String, String> authorMap = new HashMap<>();
		for(Author author:authors){
			authorMap.put(Long.toString(author.getId()), author.getName());
			System.out.println(author.getName()+" / "+author.getId());
		}
		return authorMap;
	}
}
