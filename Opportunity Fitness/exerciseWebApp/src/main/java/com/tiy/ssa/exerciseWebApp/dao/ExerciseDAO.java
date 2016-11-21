package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Exercise;

@Transactional
@Repository
public class ExerciseDAO implements IExerciseDAO{

	  @Autowired
	    private HibernateTemplate  hibernateTemplate;
	
	@Override
	public Exercise getExerciseByName(String exName) {
		List<Exercise> exercises = (List<Exercise>)hibernateTemplate.find(" FROM Exercise WHERE exercise_name = ?", exName);
		return exercises.get(0);
	}
	
	

	@Override
	public List<Exercise> getExerciseListByCategory(Integer category_id) {
		
		List<Exercise> exercises =  (List<Exercise>)hibernateTemplate.find(" FROM Exercise WHERE category_id = ?", category_id);
		return exercises;
	}

	@Override
	public List<Exercise> getExerciseListByIntensity(Integer intensity) {
		List<Exercise> exercises =  (List<Exercise>)hibernateTemplate.find(" FROM Exercise WHERE intensity = ?", intensity);
		return exercises;
	}



	@Override
	public Exercise getExerciseById(Integer id) {
		List<Exercise> exercises = (List<Exercise>)hibernateTemplate.find(" FROM Exercise WHERE id = ?", id);
		return exercises.get(0);
	}

	
}
