package com.tiy.ssa.exerciseWebApp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Date_Map;

@Transactional
@Repository
public class Date_MapDAO implements IDate_MapDAO{

	 @Autowired
	   private HibernateTemplate  hibernateTemplate;
	 
	@Override
	public boolean insertDateMap(Date_Map date_map) {
		hibernateTemplate.save(date_map);
		return true;
	}

	@Override
	public Date_Map getDateMapByDateUser(String userid, Date today) {
		List<Date_Map> dm = (List<Date_Map>)hibernateTemplate.find(" from Date_Map where user_id = ? and date_val = ?",userid,today);
		return dm.get(0);
	}


	@Override
	public boolean deleteDateMapByUserid(String userid) {
		int count = hibernateTemplate.bulkUpdate("delete from Date_Map where user_id = ? ", userid);
		boolean response ;
		if (count > 0 ) response = true;
		else response = false;
		return response;
	}


	@Override
	public Date_Map getDateMapByDayUser(String userid, String dayno) {
		List<Date_Map> dm = (List<Date_Map>)hibernateTemplate.find(" from Date_Map where user_id = ? and dayNo = ?",userid,dayno);
		return dm.get(0);
	}

	@Override
	public List<Date_Map> getDateMapByUser(String userid) {
		List<Date_Map> dm = (List<Date_Map>)hibernateTemplate.find(" from Date_Map where user_id = ? ",userid);
		return dm;
	}

}
