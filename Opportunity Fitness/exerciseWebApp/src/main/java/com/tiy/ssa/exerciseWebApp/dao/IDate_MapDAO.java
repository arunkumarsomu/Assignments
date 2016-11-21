package com.tiy.ssa.exerciseWebApp.dao;

import java.util.Date;
import java.util.List;

import com.tiy.ssa.exerciseWebApp.entity.Date_Map;

public interface IDate_MapDAO {

	boolean insertDateMap(Date_Map date_map);
	
	Date_Map getDateMapByDateUser(String userid,Date today);
	
	Date_Map getDateMapByDayUser(String userid, String dayno);
	
	List<Date_Map> getDateMapByUser(String userid);
	
	boolean deleteDateMapByUserid(String userid);
	
	
	
	
}
