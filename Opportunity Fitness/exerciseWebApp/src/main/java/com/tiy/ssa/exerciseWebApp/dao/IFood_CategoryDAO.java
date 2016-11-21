package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Food_Category;

public interface IFood_CategoryDAO {

	Integer getFoodCategoryByDesc(String desc);
	List<Food_Category> getAllFoodCategory();
}
