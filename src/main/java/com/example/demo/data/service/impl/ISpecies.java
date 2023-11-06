package com.example.demo.data.service.impl;

import java.util.List;

import com.example.demo.data.model.Species;


public interface ISpecies {

	List<Species> getAllSpecies();
	Species findById(long id);
	Species findByName(String name);
	Species save(Species std);
	void deleteById(long id);
}
