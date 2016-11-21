package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IExercise_CategoryDAO;
import com.tiy.ssa.exerciseWebApp.entity.Exercise_Category;

@Service
public class Exercise_CategoryService implements IExercise_CategoryService {

	@Autowired
	private IExercise_CategoryDAO exercise_categoryDAO;

	@Override
	public Integer getExerciseCategoryByDesc(String desc) {
		return exercise_categoryDAO.getExerciseCategoryByDesc(desc);
	}

	@Override
	public List<Exercise_Category> getAllExerciseCategory() {
		return  exercise_categoryDAO.getAllExerciseCategory();
	}
	
	
}
