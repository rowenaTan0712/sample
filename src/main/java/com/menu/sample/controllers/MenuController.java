package com.menu.sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.sample.exception.RecordNotFoundException;
import com.menu.sample.models.Food;
import com.menu.sample.services.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping
	public ResponseEntity<List<Food>> getMenus(){
		List<Food> foods = menuService.getMenus();
		return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Food> getMenu(@PathVariable("id") Long id) throws RecordNotFoundException {
		Food food = menuService.getMenuById(id);
		return new ResponseEntity<Food>(food, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus removeMenu(@PathVariable("id") Long id) throws RecordNotFoundException {
		menuService.removeMenu(id);
		return HttpStatus.ACCEPTED;
	}
	
	@PutMapping
	public ResponseEntity<Food> addMenu(@RequestBody Food food) {
		Food response = menuService.addMenu(food);
		return new ResponseEntity<Food>(response, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Food> updateMenu(@RequestBody Food food){
		Food response = menuService.updateMenu(food);
		return new ResponseEntity<Food>(response, HttpStatus.OK);
	}
}
