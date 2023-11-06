package com.example.demo.data.service.impl;

import java.util.List;

import com.example.demo.data.model.Rang;

public interface IRang {
	List<Rang>  getAllRang();
	Rang findById(long id);
	Rang findByName(String name);
	Rang save(Rang std);
	void deleteById(long id);
	
}
