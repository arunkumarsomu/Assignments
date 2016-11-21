package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Food_Tracking;


public interface IFood_TrackingDAO {

	
	boolean insertFoodTrack(Food_Tracking food_track);
	
	boolean updateFoodTrack(Food_Tracking food_track);
	
	List<Food_Tracking> getFoodTrackByUser(String userid);
	
	List<Food_Tracking> getFoodTrackByUserByDay(String userid,String dayno);
	
	boolean deleteFoodTrackByDay(String userid,String dayno);
	
}
