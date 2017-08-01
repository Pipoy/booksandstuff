package com.mindteck.booksandstuff.service.cd.impl;

import com.mindteck.booksandstuff.dao.cd.ArtistDAO;
import com.mindteck.booksandstuff.dao.cd.CDDAO;
import com.mindteck.booksandstuff.dao.cd.MusicGenreDAO;
import com.mindteck.booksandstuff.dao.cd.ProducerDAO;
import com.mindteck.booksandstuff.dao.item.CategoryDAO;
import com.mindteck.booksandstuff.dto.CD.CDDTO;
import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.service.cd.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */

@Service
public class CDServiceImpl implements CDService {


	@Autowired
	private CDDAO cddao;

	@Autowired
	private ArtistDAO artistDAO;

	@Autowired
	private MusicGenreDAO musicGenreDAO;

	@Autowired
	private ProducerDAO producerDAO;

	@Autowired
	private CategoryDAO categoryDAO;



	@Transactional
	@Override
	public void add(CDDTO cddto) {
		CD cd = new CD();

		cd.setId(cddto.getId());
		cd.setName(cddto.getName());
		cd.setPrice(Long.parseLong(cddto.getPrice()));
		cd.setCategory(categoryDAO.getCategory(Long.parseLong(cddto.getCategory())));

		cd.setActive(cddto.getActive());
		cd.setDescription(cddto.getDescription());

		cd.setArtist(artistDAO.getArtist(Long.parseLong(cddto.getArtist())));
		cd.setMusicGenre(musicGenreDAO.getMusicGenre(Long.parseLong(cddto.getMusicGenre())));
		cd.setProducer(producerDAO.getProducer(Long.parseLong(cddto.getProducer())));

		cddao.add(cd);


	}

	@Transactional(readOnly = true)
	@Override
	public List<CD> getCDs() {
		return cddao.getCDs();
	}

	@Transactional(readOnly = true)
	@Override
	public CDDTO getCD(Long id) {
		CD cd = cddao.getCD(id);

		CDDTO cddto = new CDDTO();

		cddto.setId(cd.getId());
		cddto.setName(cd.getName());
		cddto.setPrice(cd.getPrice().toString());

		cddto.setActive(cd.getActive());
		cddto.setDescription(cd.getDescription());

		cddto.setCategory(Long.toString(cd.getCategory().getId()));

		cddto.setArtist(Long.toString(cd.getArtist().getId()));
		cddto.setArtistName(cd.getArtist().getName());

		cddto.setMusicGenre(Long.toString(cd.getMusicGenre().getId()));
		cddto.setMusicGenreName(cd.getMusicGenre().getName());

		cddto.setProducer(Long.toString(cd.getProducer().getId()));
		cddto.setProducerName(cd.getProducer().getName());

		return cddto;
	}
}
