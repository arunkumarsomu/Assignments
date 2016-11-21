package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Exercise;

public interface IExerciseService {
	
	Exercise getExerciseByName(String exName);
	Exercise getExerciseById(Integer id);
	List<Exercise> getExerciseListByCategory(Integer category_id);
	List<Exercise> getExerciseListByIntensity(Integer intensity);
}
