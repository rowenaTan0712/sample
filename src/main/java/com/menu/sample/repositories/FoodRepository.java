package com.menu.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.sample.models.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
