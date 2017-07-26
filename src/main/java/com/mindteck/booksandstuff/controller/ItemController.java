package com.mindteck.booksandstuff.controller;

import com.mindteck.booksandstuff.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Philip Lozada on 7/25/2017.
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;


//	@GetMapping("items")
//	public String listItems(Model model) {
//		List<Item> items = itemService.getAllItems();
//		model.addAttribute("itemList", items);
//
//		return "items";
//	}

}
