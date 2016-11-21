package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Exercise_Tracking;

public interface IExercise_TrackingService {
	
	boolean insertWorkoutRoutine(Exercise_Tracking ex_track);
	
	boolean updateWorkoutRoutine(Exercise_Tracking ex_track);
	
	List<Exercise_Tracking> getWorkoutRoutineByUser(String userid);
	
	List<Exercise_Tracking> getWorkoutRoutineByUserByDay(String userid,String dayno);
	
	boolean deleteWorkoutRoutine(String userid);
	
	boolean deleteOneWorkout(String userid,String dayno,Integer exid);
}
