package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IExercise_CategoryDAO;
import com.tiy.ssa.exerciseWebApp.dao.IFood_CategoryDAO;
import com.tiy.ssa.exerciseWebApp.entity.Food_Category;

@Service
public class Food_CategoryService implements IFood_CategoryService{

	@Autowired
	private IFood_CategoryDAO food_categoryDAO;
	
	@Override
	public Integer getFoodCategoryByDesc(String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food_Category> getAllFoodCategory() {
		return food_categoryDAO.getAllFoodCategory();
	}

}
