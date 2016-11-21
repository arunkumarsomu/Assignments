package com.tiy.ssa.exerciseWebApp.dao;

import com.tiy.ssa.exerciseWebApp.entity.Userinfo;

public interface IUserinfoDAO {
	
	Userinfo getUserById(int studentId);
	boolean addUser(Userinfo user);
	void updateUser(Userinfo user);
	void deleteUser(int userId);
	Userinfo getUserByUsername(String uname);
}
