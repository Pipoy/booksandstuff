package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.service.cd.ArtistService;
import com.mindteck.booksandstuff.service.cd.CDService;
import com.mindteck.booksandstuff.service.cd.MusicGenreService;
import com.mindteck.booksandstuff.service.cd.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
@Controller
public class CDController {

	@Autowired
	private CDService cdService;

	@Autowired
	private ArtistService artistService;

	@Autowired
	private MusicGenreService musicGenreService;

	@Autowired
	private ProducerService producerService;


	@GetMapping("cdManager")
	public String listCDs(Model model) {
		List<CD> cds = cdService.getCDs();
		model.addAttribute("cdList", cds);
		return "cdManager";
	}

}
