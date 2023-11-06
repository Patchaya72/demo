package com.example.demo.data.service.impl;

import java.util.List;

import com.example.demo.data.model.Users;

public interface IUsers {
	List<Users> getAllUsers();
	Users findById(long id);
	Users findByEmail(String email);
	Users save(Users std);
	void deleteById(long id);
}
