package com.example.demo.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.data.model.Species;
import com.example.demo.data.repository.SpeciesRepository;
import com.example.demo.data.service.impl.ISpecies;

@Service
public class SpeciesService implements ISpecies {
	SpeciesRepository speciesRepository;
		
	public SpeciesService(SpeciesRepository speciesRepository ) {
		this.speciesRepository = speciesRepository;
	}

	@Override
	public List<Species> getAllSpecies() {
		// TODO Auto-generated method stub
		return speciesRepository.findAll();
	}

	@Override
	public Species findById(long id) {
		// TODO Auto-generated method stub
		return speciesRepository.findById(id);
	}

	@Override
	public Species findByName(String name) {
		// TODO Auto-generated method stub
		return speciesRepository.findByName(name);
	}

	@Override
	public Species save(Species std) {
		// TODO Auto-generated method stub
		return speciesRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		speciesRepository.deleteById(id);
		
	}
	public Optional<Species> finOptionalById(long id){
		return speciesRepository.findOptionalById(id);
	}
}
