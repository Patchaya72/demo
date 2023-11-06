package com.example.demo.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Species;

@Repository
public interface SpeciesRepository  extends JpaRepository<Species,Long>{
	Species findById(long id);
	Species findByName(String name);
	Optional<Species> findOptionalById(long id);
}
