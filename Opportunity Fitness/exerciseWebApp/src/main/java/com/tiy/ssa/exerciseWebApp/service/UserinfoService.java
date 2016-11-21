package com.tiy.ssa.exerciseWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiy.ssa.exerciseWebApp.dao.IUserinfoDAO;
import com.tiy.ssa.exerciseWebApp.entity.Userinfo;

@Service
public class UserinfoService implements IUserinfoService {

	@Autowired
	private IUserinfoDAO userinfoDAO;
	@Override
	public Userinfo getUserById(int userid) {
		return userinfoDAO.getUserById(userid);
	}

	@Override
	public boolean addUser(Userinfo user) {
	return userinfoDAO.addUser(user);
	}

	@Override
	public void updateUser(Userinfo user) {
	 userinfoDAO.updateUser(user);
		
	}

	@Override
	public void deleteUser(int userId) {
	 userinfoDAO.deleteUser(userId);
		
	}

	@Override
	public Userinfo getUserByUsername(String uname) {
		return userinfoDAO.getUserByUsername(uname);
	}

}
