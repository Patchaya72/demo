package com.example.demo.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.data.model.Typetree;
import com.example.demo.data.repository.TypetreeRepository;
import com.example.demo.data.service.impl.ITypetree;

@Service
public class TypetreeService implements ITypetree {
	TypetreeRepository typetreeRepository;
	
	public TypetreeService(TypetreeRepository typetreeRepository ) {
		this.typetreeRepository = typetreeRepository;
	}

	@Override
	public List<Typetree> getAllTypetree() {
		// TODO Auto-generated method stub
		return typetreeRepository.findAll();
	}

	@Override
	public Typetree findById(long id) {
		// TODO Auto-generated method stub
		return typetreeRepository.findById(id);
	}

	@Override
	public Typetree findByName(String name) {
		// TODO Auto-generated method stub
		return typetreeRepository.findByName(name);
	}

	@Override
	public Typetree save(Typetree std) {
		// TODO Auto-generated method stub
		return typetreeRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		typetreeRepository.deleteById(id);
		
	}
	public Optional<Typetree> finOptionalById(long id){
		return typetreeRepository.findOptionalById(id);
	}
	
}
