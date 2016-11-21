package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Food_Tracking;


@Transactional
@Repository
public class Food_TrackingDAO implements IFood_TrackingDAO{

	 @Autowired
	   private HibernateTemplate  hibernateTemplate;
	
	
	@Override
	public boolean insertFoodTrack(Food_Tracking food_track) {
		hibernateTemplate.save(food_track);
		return true;
	}

	@Override
	public boolean updateFoodTrack(Food_Tracking food_track) {
		hibernateTemplate.update(food_track);
		return true;
	}

	@Override
	public List<Food_Tracking> getFoodTrackByUser(String userid) {
		List<Food_Tracking> fd_track = (List<Food_Tracking>)hibernateTemplate.find(" from Food_Tracking where user_id = ? ",userid);
		return fd_track;
	}

	@Override
	public List<Food_Tracking> getFoodTrackByUserByDay(String userid, String dayno) {
		List<Food_Tracking> fd_track = (List<Food_Tracking>)hibernateTemplate.find(" from Food_Tracking where user_id = ? and dayNo = ?",userid,dayno);
		return fd_track;
	}

	@Override
	public boolean deleteFoodTrackByDay(String userid, String dayno) {
		int count = hibernateTemplate.bulkUpdate("delete from Food_Tracking where user_id = ?", userid);
		boolean response ;
		if (count > 0 ) response = true;
		else response = false;
		return response;
	}
	

}
