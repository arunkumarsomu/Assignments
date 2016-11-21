package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IFoodDAO;
import com.tiy.ssa.exerciseWebApp.entity.Food;

@Service
public class FoodService implements IFoodService{

	@Autowired
	private IFoodDAO food;
	
	@Override
	public Food getFoodByName(String foodName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Food getFoodById(Integer id)
	{
		return food.getFoodById(id);
	}

	@Override
	public List<Food> getFoodListByCategory(Integer cat_id) {
		return food.getFoodListByCategory(cat_id);
	}

	@Override
	public List<Food> getAllFoodC() {
		return food.getAllFood();
	}

	@Override
	public void storeFood(List<Food> foodList) {
		food.storeFood(foodList);
		
	}
}
