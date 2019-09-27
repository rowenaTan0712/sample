package com.menu.sample.services;

import java.util.List;

import com.menu.sample.exception.RecordNotFoundException;
import com.menu.sample.models.Food;

public interface MenuService {
	
	public List<Food> getMenus();
	public Food addMenu(Food food);
	public Food updateMenu(Food food);
	public void removeMenu(Long id) throws RecordNotFoundException;
	public Food getMenuById(Long id) throws RecordNotFoundException;
}
