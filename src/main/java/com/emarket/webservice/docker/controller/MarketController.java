package com.emarket.webservice.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emarket.webservice.docker.model.Item;
import com.emarket.webservice.docker.service.MarketService;



@RestController
@RequestMapping("/market")
public class MarketController {
	@Autowired
	private MarketService marketService;

	@GetMapping("/get")
	public List<Item> getAll() {
		List<Item> items=marketService.getAllItems();
		System.out.println("Displaying");
		System.out.println(items);
		return items;
	}
	@GetMapping("/getById")
	public Item getById(@RequestParam("id") int id) {
		Item item=marketService.getItemById(id);
		return item;
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam("id") int id) {
		//Item previousItem=marketService.getItemById(id);
		marketService.delete(id);
	}
	
	
	@PostMapping("/save")
	public void save(@RequestBody Item item) {

		Object presentId=item.getId();
		List<Item> previousItems=marketService.getAllItems();
		int previousId=(int)previousItems.get(previousItems.size()-1).getId();

		if(presentId == null) {
			item.setId(previousId+1);
			marketService.save(item);
		}
		marketService.save(item);
	}
	
	
	@GetMapping("/welcome")
	public ResponseEntity<List<Item>> welcome() {

		return new ResponseEntity<List<Item>>(marketService.getAllItems(),HttpStatus.OK);
	}
}
