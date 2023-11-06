package com.example.demo.data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.json.UsersListJson;
import com.example.demo.data.model.Users;
import com.example.demo.data.payload.UsersPayload;
import com.example.demo.data.service.UsersService;

@Service
public class UsersBusiness {
	@Autowired
	
	UsersService usersService;
	public List<UsersListJson> getListUsers(){
		return  UsersListJson.packJsons(usersService.getAllUsers());
		
	}
	public UsersListJson getUsersId(long id) {
		return UsersListJson.packJson(usersService.findById(id));
	}
	public UsersListJson getUsersByEmail(String email) {
		return UsersListJson.packJson(usersService.findByEmail(email));
	}
	
	public void saveUsers(UsersPayload std) {
		Users users = new Users(
				std.getUsername(),
				std.getEmail(),
				std.getPassword(),
				std.getRid());
		usersService.save(users);
	}
	public void updateUsers(long id ,UsersPayload payload) {
		Users usersData = usersService.findById(id);
		usersData.setEmail(payload.getEmail());
		usersData.setUsername(payload.getUsername());
		usersData.setRid(payload.getRid());
		usersData.setPassword(payload.getPassword());
	
	}
	public void deleteUsers(long id) {
		usersService.deleteById(id);
	}
}
