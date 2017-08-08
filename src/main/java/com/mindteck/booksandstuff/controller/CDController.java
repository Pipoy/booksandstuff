package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.dto.CD.CDDTO;
import com.mindteck.booksandstuff.enitities.cd.CD;
import com.mindteck.booksandstuff.service.CategoryService;
import com.mindteck.booksandstuff.service.cd.ArtistService;
import com.mindteck.booksandstuff.service.cd.CDService;
import com.mindteck.booksandstuff.service.cd.MusicGenreService;
import com.mindteck.booksandstuff.service.cd.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Philip Lozada on 8/1/2017.
 */
@Controller
@RequestMapping("/admin/cdManager")
public class CDController {

	@Autowired
	private CDService cdService;

	@Autowired
	private ArtistService artistService;

	@Autowired
	private MusicGenreService musicGenreService;

	@Autowired
	private ProducerService producerService;

	@Autowired
	private CategoryService categoryService;


	private Path path;


	@GetMapping("/")
	public String listCDs(Model model) {
		List<CD> cds = cdService.getCDs();
		model.addAttribute("cdList", cds);
		return "cdManager";
	}


	@GetMapping("cdForm")
	public String showCDForm(Model model) {
		CD cd = new CD();

		model.addAttribute("cds", cd);
		model.addAttribute("artists", artistService.getArtists());
		model.addAttribute("producers", producerService.getProducers());
		model.addAttribute("musicGenre", musicGenreService.getMusicGenres());
		model.addAttribute("category", categoryService.getCategories());

		return "formCD";
	}

	@PostMapping("saveCD")
	public String saveCD(@ModelAttribute("cds") @Valid CDDTO cddto, BindingResult result, Model model, HttpServletRequest request){

		if (result.hasErrors()) {

			model.addAttribute("artists", artistService.getArtists());
			model.addAttribute("producers", producerService.getProducers());
			model.addAttribute("musicGenre", musicGenreService.getMusicGenres());
			model.addAttribute("category", categoryService.getCategories());

			return "formCD";
		}

		cdService.add(cddto);

		MultipartFile cdImage = cddto.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\resources\\images\\" + cddto.getId() + ".png");

		if (cdImage != null && !cdImage.isEmpty()) {
			try {
				cdImage.transferTo(new File(path.toString()));
				System.out.println(path);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed!,", e);


			}
		}

		return "redirect:/admin/cdManager/";
	}

	@GetMapping("updateFormCD")
	public String updateFormCD(@RequestParam("cdId") String id, Model model) {
		CDDTO cd = cdService.getCD(Long.parseLong(id));

		model.addAttribute("cds", cd);
		model.addAttribute("artists", artistService.getArtists());
		model.addAttribute("producers", producerService.getProducers());
		model.addAttribute("musicGenre", musicGenreService.getMusicGenres());
		model.addAttribute("category", categoryService.getCategories());

		return "formCD";

	}

}
