package com.example.demo.data.service.impl;

import java.util.List;

import com.example.demo.data.model.Tree;

public interface ITree {
	
	List<Tree> getAllTree();
	Tree findById(long id);
	Tree findByName(String name);
	Tree save(Tree std);
	void deleteById(long id);
}
