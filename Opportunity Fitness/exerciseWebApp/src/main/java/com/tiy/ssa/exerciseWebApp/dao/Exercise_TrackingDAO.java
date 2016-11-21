package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Exercise_Tracking;

@Transactional
@Repository
public class Exercise_TrackingDAO implements IExercise_TrackingDAO {

	 @Autowired
	   private HibernateTemplate  hibernateTemplate;
	
	@Override
	public boolean insertWorkoutRoutine(Exercise_Tracking ex_track) {
		hibernateTemplate.save(ex_track);
		return true;
	}

	@Override
	public boolean updateWorkoutRoutine(Exercise_Tracking ex_track) {
		hibernateTemplate.update(ex_track);
		return true;
	}

	@Override
	public List<Exercise_Tracking> getWorkoutRoutineByUser(String userid) {
		List<Exercise_Tracking> ex_track = (List<Exercise_Tracking>)hibernateTemplate.find(" from Exercise_Tracking where user_id = ? ",userid);
		return ex_track;
	}

	@Override
	public List<Exercise_Tracking> getWorkoutRoutineByUserByDay(String userid, String dayno) {
		List<Exercise_Tracking> ex_track = (List<Exercise_Tracking>)hibernateTemplate.find(" from Exercise_Tracking where user_id = ? and dayNo = ?",userid,dayno);
		return ex_track;
	}

	@Override
	public boolean deleteWorkoutRoutine(String userid) {
		int count = hibernateTemplate.bulkUpdate("delete from Exercise_Tracking where user_id = ?", userid);
		boolean response ;
		if (count > 0 ) response = true;
		else response = false;
		return response;
	}
	
	@Override
	public boolean deleteOneWorkout(String userid,String dayno,Integer exid) {
		int count = hibernateTemplate.bulkUpdate("delete from Exercise_Tracking where user_id = ? and dayNo = ? and exercise_id = ? ", userid, dayno, exid);
		boolean response ;
		System.out.println("COunt ="+count);
		System.err.println("COunt ="+count);
		if (count > 0 ) response = true;
		else response = false;
		return response;
	}

}
