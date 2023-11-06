package com.example.demo.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.data.model.Users;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.data.service.impl.IUsers;

@Service

public class UsersService implements IUsers {
	UserRepository userRepository;
	
	public UsersService(UserRepository userRepository ) {
		this.userRepository = userRepository;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Users findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public Users save(Users std) {
		// TODO Auto-generated method stub
		return userRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	public Optional<Users> finOptionalById(long id){
		return userRepository.findOptionalById(id);
	}
}
