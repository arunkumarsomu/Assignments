package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Food_Category;

public interface IFood_CategoryService {

	Integer getFoodCategoryByDesc(String desc);
	List<Food_Category> getAllFoodCategory();
}
