package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Exercise;
import com.tiy.ssa.exerciseWebApp.entity.Food;

public interface IFoodDAO {

	Food getFoodByName(String foodName);
	Food getFoodById(Integer id);
	List<Food> getFoodListByCategory(Integer cat_id);
	List<Food> getAllFood();
	void storeFood(List<Food> foodList);
	
}
