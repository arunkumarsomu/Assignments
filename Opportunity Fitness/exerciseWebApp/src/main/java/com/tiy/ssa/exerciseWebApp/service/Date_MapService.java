package com.tiy.ssa.exerciseWebApp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IDate_MapDAO;
import com.tiy.ssa.exerciseWebApp.entity.Date_Map;

@Service
public class Date_MapService implements IDate_MapService {

	
	@Autowired
	private IDate_MapDAO date_mapDAO;
	
	
	@Override
	public boolean insertDateMap(Date_Map date_map) {
		// TODO Auto-generated method stub
		return date_mapDAO.insertDateMap(date_map);
	}

	@Override
	public Date_Map getDateMapByDateUser(String userid, Date today) {
		// TODO Auto-generated method stub
		return date_mapDAO.getDateMapByDateUser(userid, today);
	}

	@Override
	public Date_Map getDateMapByDayUser(String userid, String dayno) {
		// TODO Auto-generated method stub
		return date_mapDAO.getDateMapByDayUser(userid, dayno);
	}

	@Override
	public List<Date_Map> getDateMapByUser(String userid) {
		// TODO Auto-generated method stub
		return date_mapDAO.getDateMapByUser(userid);
	}

	@Override
	public boolean deleteDateMapByUserid(String userid) {
		// TODO Auto-generated method stub
		return date_mapDAO.deleteDateMapByUserid(userid);
	}
	
	

}
