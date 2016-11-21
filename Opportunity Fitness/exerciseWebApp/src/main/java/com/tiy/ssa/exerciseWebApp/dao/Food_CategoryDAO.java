package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Food_Category;

@Transactional
@Repository
public class Food_CategoryDAO implements IFood_CategoryDAO{

	@Autowired
    private HibernateTemplate  hibernateTemplate;
	
	@Override
	public Integer getFoodCategoryByDesc(String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food_Category> getAllFoodCategory() {
		
		List<Food_Category> foodCategories = (List<Food_Category>)hibernateTemplate.find("FROM Food_Category");
		
		return foodCategories;
	}

}
