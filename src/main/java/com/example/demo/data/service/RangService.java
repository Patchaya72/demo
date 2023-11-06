package com.example.demo.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.data.model.Rang;
import com.example.demo.data.repository.RangRepository;
import com.example.demo.data.service.impl.IRang;
@Service
public class RangService implements IRang{ 
	RangRepository rangRepository;
	
	public RangService(RangRepository rangRepository ) {
		this.rangRepository = rangRepository;
	}

	@Override
	public List<Rang> getAllRang() {
		// TODO Auto-generated method stub
		return rangRepository.findAll();
	}

	@Override
	public Rang findById(long id) {
		// TODO Auto-generated method stub
		return rangRepository.findById(id);
	}

	@Override
	public Rang findByName(String name) {
		// TODO Auto-generated method stub
		return rangRepository.findByName(name);
	}

	@Override
	public Rang save(Rang std) {
		// TODO Auto-generated method stub
		return rangRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		rangRepository.deleteById(id);
	}
	public Optional<Rang> finOptionalById(long id){
		return rangRepository.findOptionalById(id);
	}

}
