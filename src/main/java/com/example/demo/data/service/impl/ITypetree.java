package com.example.demo.data.service.impl;

import java.util.List;

import com.example.demo.data.model.Typetree;

public interface ITypetree {
	List<Typetree>  getAllTypetree();
	Typetree findById(long id);
	Typetree findByName(String name);
	Typetree save(Typetree std);
	void deleteById(long id);

}
