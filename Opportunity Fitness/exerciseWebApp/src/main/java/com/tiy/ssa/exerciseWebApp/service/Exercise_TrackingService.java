package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IExercise_TrackingDAO;
import com.tiy.ssa.exerciseWebApp.entity.Exercise_Tracking;


@Service
public class Exercise_TrackingService implements IExercise_TrackingService {

	@Autowired
	private IExercise_TrackingDAO exercise_trackingDAO;
	
	@Override
	public boolean insertWorkoutRoutine(Exercise_Tracking ex_track) {
		return exercise_trackingDAO.insertWorkoutRoutine(ex_track);
	}

	@Override
	public boolean updateWorkoutRoutine(Exercise_Tracking ex_track) {
		return exercise_trackingDAO.updateWorkoutRoutine(ex_track);
	}

	@Override
	public List<Exercise_Tracking> getWorkoutRoutineByUser(String userid) {
		return exercise_trackingDAO.getWorkoutRoutineByUser(userid);
	}

	@Override
	public List<Exercise_Tracking> getWorkoutRoutineByUserByDay(String userid, String dayno) {
		return exercise_trackingDAO.getWorkoutRoutineByUserByDay(userid, dayno);
	}

	@Override
	public boolean deleteWorkoutRoutine(String userid) {
		return exercise_trackingDAO.deleteWorkoutRoutine(userid);
		
	}
	
	public boolean deleteOneWorkout(String userid,String dayno,Integer exid){
		return exercise_trackingDAO.deleteOneWorkout(userid, dayno, exid);
		
	}
	

}
