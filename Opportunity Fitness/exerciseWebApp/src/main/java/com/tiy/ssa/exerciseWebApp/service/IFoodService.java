package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Food;

public interface IFoodService {

	Food getFoodByName(String foodName);
	Food getFoodById(Integer id);
	List<Food> getFoodListByCategory(Integer cat_id);
	List<Food> getAllFoodC();
	void storeFood(List<Food> foodList);
}
