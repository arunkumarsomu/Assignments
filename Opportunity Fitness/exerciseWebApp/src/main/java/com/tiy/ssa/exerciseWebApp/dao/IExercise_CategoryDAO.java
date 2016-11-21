package com.tiy.ssa.exerciseWebApp.dao;
import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Exercise_Category;
public interface IExercise_CategoryDAO {
	
	Integer getExerciseCategoryByDesc(String desc);
	List<Exercise_Category> getAllExerciseCategory();
}
