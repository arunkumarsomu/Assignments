package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Food;

@Transactional
@Repository
public class FoodDAO implements IFoodDAO{

	@Autowired
    private HibernateTemplate  hibernateTemplate;
	
	@Override
	public Food getFoodByName(String foodName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Food getFoodById(Integer id) {
		List<Food> foods = (List<Food>)hibernateTemplate.find("FROM Food WHERE id =?",id);
		
		if (!foods.isEmpty())
			return foods.get(0);
		else
			return null;
	}

	@Override
	public List<Food> getFoodListByCategory(Integer cat_id) {
		List<Food> foods = (List<Food>)hibernateTemplate.find("FROM Food WHERE category_id =?",cat_id);
		return foods;
	}

	@Override
	public List<Food> getAllFood() {
		List<Food> foods = (List<Food>)hibernateTemplate.find("FROM Food");
		return foods;
	}

	@Override
	public void storeFood(List<Food> foodList) {
		
		for(Food toAdd: foodList)
		{
			System.out.println(toAdd.getDescription());
			//hibernateTemplate.save(toAdd);
		}
		
		
	}

}
