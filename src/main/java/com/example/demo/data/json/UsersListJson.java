package com.example.demo.data.json;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.data.model.Rang;
import com.example.demo.data.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersListJson {

	private long id;
	private String username;
	private String email;
	private String password;
	private Rang rid;
	
	public static UsersListJson packJson(Users user) {
		
		UsersListJson ulj =new UsersListJson();
		ulj.setId(user.getId());
		ulj.setUsername(user.getUsername());
		ulj.setEmail(user.getEmail());
		ulj.setPassword(user.getPassword());
		ulj.setRid(user.getRid());
		
		return ulj;
	}
	
	public static List<UsersListJson> packJsons(List<Users> users){
		List<UsersListJson> userListJson =new ArrayList<UsersListJson>();
		for (Users user : users) {
			userListJson.add(packJson(user));
		}
		return userListJson;
	}
	
}
