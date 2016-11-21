package com.tiy.ssa.exerciseWebApp.service;
import com.tiy.ssa.exerciseWebApp.entity.Userinfo;

public interface IUserinfoService {
	
	Userinfo getUserById(int Id);
	boolean addUser(Userinfo user);
	void updateUser(Userinfo user);
	void deleteUser(int userId);
	Userinfo getUserByUsername(String uname);

}