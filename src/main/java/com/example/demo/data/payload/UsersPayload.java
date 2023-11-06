package com.example.demo.data.payload;

import com.example.demo.data.model.Rang;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsersPayload {
	private String username;
	private String email;
	private String password;
	private Rang rid;
}
