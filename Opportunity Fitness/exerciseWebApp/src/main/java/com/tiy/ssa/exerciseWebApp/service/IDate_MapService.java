package com.tiy.ssa.exerciseWebApp.service;

import java.util.Date;
import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Date_Map;

public interface IDate_MapService {

	boolean insertDateMap(Date_Map date_map);
	
	Date_Map getDateMapByDateUser(String userid,Date today);
	
	Date_Map getDateMapByDayUser(String userid, String dayno);
	
	List<Date_Map> getDateMapByUser(String userid);
	
	boolean deleteDateMapByUserid(String userid);
	
}
