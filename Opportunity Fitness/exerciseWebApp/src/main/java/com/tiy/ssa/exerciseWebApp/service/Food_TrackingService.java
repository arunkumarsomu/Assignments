package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IFood_TrackingDAO;
import com.tiy.ssa.exerciseWebApp.entity.Food_Tracking;

@Service
public class Food_TrackingService implements IFood_TrackingService {

	
	@Autowired
	private IFood_TrackingDAO food_trackingDAO;
	
	
	@Override
	public boolean insertFoodTrack(Food_Tracking food_track) {
		return food_trackingDAO.insertFoodTrack(food_track);
	}

	@Override
	public boolean updateFoodTrack(Food_Tracking food_track) {
		return food_trackingDAO.updateFoodTrack(food_track);
	}

	@Override
	public List<Food_Tracking> getFoodTrackByUser(String userid) {
		return food_trackingDAO.getFoodTrackByUser(userid);
	}

	@Override
	public List<Food_Tracking> getFoodTrackByUserByDay(String userid, String dayno) {
		return food_trackingDAO.getFoodTrackByUserByDay(userid, dayno);
	}

	@Override
	public boolean deleteFoodTrackByDay(String userid, String dayno) {
		return food_trackingDAO.deleteFoodTrackByDay(userid, dayno);
	}
	
	

}
