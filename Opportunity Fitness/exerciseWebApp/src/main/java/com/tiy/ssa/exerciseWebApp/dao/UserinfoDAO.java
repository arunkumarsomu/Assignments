package com.tiy.ssa.exerciseWebApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiy.ssa.exerciseWebApp.entity.Userinfo;

@Transactional
@Repository
public class UserinfoDAO implements IUserinfoDAO {


    @Autowired
    private HibernateTemplate  hibernateTemplate;

	@Override
	public Userinfo getUserById(int id) {
		Userinfo user=(Userinfo)hibernateTemplate.get(Userinfo.class,id);
        return user; 
	}

	@Override
	public boolean addUser(Userinfo user) {
		hibernateTemplate.save(user);
        return true;
	}

	@Override
	public void updateUser(Userinfo user) {
		hibernateTemplate.update(user);
		
	}

	@Override
	public void deleteUser(int userId) {
		Userinfo user=(Userinfo)hibernateTemplate.get(Userinfo.class,userId);
    	hibernateTemplate.delete(user);
	}

	@Override
	public Userinfo getUserByUsername(String uname) {
		List<Userinfo> user = (List<Userinfo>)hibernateTemplate.find(" from Userinfo where username = ?", uname);
		Userinfo returnUser ;
		if (user.isEmpty()){
			returnUser = new Userinfo("Not found","not found","n/a","n/a");
		}
		else 
			returnUser = user.get(0);
		
		return returnUser;
	}

}
