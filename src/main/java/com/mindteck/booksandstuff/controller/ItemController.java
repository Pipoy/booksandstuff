package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.enitities.Item;
import com.mindteck.booksandstuff.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;


	@GetMapping("itemList")
	public String listItems(Model model) {
		List<Item> items = itemService.getAllItems();
		model.addAttribute("itemList", items);

		return "listItems";
	}

}
