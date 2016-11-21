package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IExerciseDAO;
import com.tiy.ssa.exerciseWebApp.entity.Exercise;

@Service
public class ExerciseService implements IExerciseService{

	@Autowired
	private IExerciseDAO exerciseDAO;
	
	@Override
	public Exercise getExerciseByName(String exName) {
		return exerciseDAO.getExerciseByName(exName);
	}

	@Override
	public List<Exercise> getExerciseListByCategory(Integer category_id) {
		return exerciseDAO.getExerciseListByCategory(category_id);
	}

	@Override
	public List<Exercise> getExerciseListByIntensity(Integer intensity) {
		return exerciseDAO.getExerciseListByIntensity(intensity);
	}

	@Override
	public Exercise getExerciseById(Integer id) {
		return exerciseDAO.getExerciseById(id);
	}

}
