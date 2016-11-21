package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Exercise_Category;

@Transactional
@Repository
public class Exercise_CategoryDAO implements IExercise_CategoryDAO {

	  @Autowired
	    private HibernateTemplate  hibernateTemplate;
	
	@Override
	public Integer getExerciseCategoryByDesc(String desc) {
		List<Exercise_Category> ex_cat = (List<Exercise_Category>)hibernateTemplate.find(" from Exercise_Category WHERE description = ?", desc);
		return ex_cat.get(0).getId();
	}

	@Override
	public List<Exercise_Category> getAllExerciseCategory() {
		List<Exercise_Category> ex_cat = (List<Exercise_Category>)hibernateTemplate.find(" from Exercise_Category ORDER BY id ");
		return ex_cat;
	}

}
