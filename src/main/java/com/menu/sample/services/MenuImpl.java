package com.menu.sample.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menu.sample.exception.RecordNotFoundException;
import com.menu.sample.models.Food;
import com.menu.sample.repositories.FoodRepository;

@Service
public class MenuImpl implements MenuService{
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public List<Food> getMenus() {		
		return foodRepository.findAll();
	}

	@Override
	public Food addMenu(Food food) {
		food.setCreateDate(new Date());
		return foodRepository.save(food);
	}

	@Override
	public Food updateMenu(Food food) {
		Optional<Food> details = foodRepository.findById(food.getId());
		Food updateData = new Food();
		
		if(details.isPresent()) {
			updateData = details.get();
			updateData.setDateServe(food.getDateServe() != null ? food.getDateServe() : details.get().getDateServe());
			updateData.setDescription(food.getDescription() != null ? food.getDescription() : details.get().getDescription());
			updateData.setName(food.getName() != null ? food.getName() : details.get().getName());
			updateData.setUpdateDate(new Date());
			return foodRepository.save(updateData);
		}
		return updateData;
	}

	@Override
	public void removeMenu(Long id) throws RecordNotFoundException {
		Optional<Food> details = foodRepository.findById(id);
		
		if(details.isPresent()) {
			foodRepository.deleteById(details.get().getId());
		}else {
			throw new RecordNotFoundException("no record found");
		}
	}

	@Override
	public Food getMenuById(Long id) throws RecordNotFoundException {
		Optional<Food> details = foodRepository.findById(id);
		
		if(details.isPresent()) {
			return details.get();
		}else {
			throw new RecordNotFoundException("no record found");
		}
	}

}
