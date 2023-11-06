package com.example.demo.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.data.model.Tree;
import com.example.demo.data.repository.TreeRepository;
import com.example.demo.data.service.impl.ITree;

@Service
public class TreeService implements ITree{
	TreeRepository treeRepository;
	public TreeService(TreeRepository treeRepository) {
		this.treeRepository = treeRepository;
	}
	@Override
	public List<Tree> getAllTree() {
		// TODO Auto-generated method stub
		return treeRepository.findAll();
	}

	@Override
	public Tree findById(long id) {
		// TODO Auto-generated method stub
		return treeRepository.findById(id);
	}

	@Override
	public Tree findByName(String name) {
		// TODO Auto-generated method stub
		return treeRepository.findByName(name);
	}

	@Override
	public Tree save(Tree std) {
		// TODO Auto-generated method stub
		return treeRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		treeRepository.deleteById(id);
	}
	public Optional<Tree> finOptionalById(long id){
		return treeRepository.findOptionalById(id);
	}
}
