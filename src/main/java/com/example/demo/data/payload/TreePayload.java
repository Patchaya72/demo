package com.example.demo.data.payload;


import com.example.demo.data.model.Species;
import com.example.demo.data.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TreePayload {
	private String name;
	private Species spid;
	private Users uid;
}
