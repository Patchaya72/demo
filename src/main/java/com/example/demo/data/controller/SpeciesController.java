package com.example.demo.data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.business.SpeciesBusiness;
import com.example.demo.data.json.SpeciesListJson;
import com.example.demo.data.model.Species;
import com.example.demo.data.payload.SpeciesPayload;
import com.example.demo.data.service.SpeciesService;

@RestController
@RequestMapping("/api")
public class SpeciesController {
	@Autowired
	SpeciesService speciesService;
	
	@Autowired
	SpeciesBusiness speciesBusiness;
	
	public SpeciesController(SpeciesService speciesService) {
		this.speciesService = speciesService;
	}

	@PostMapping(value = "/species")
	public ResponseEntity<Void> saveSpecies(@RequestBody SpeciesPayload payload){
		speciesBusiness.saveSpecies(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/species")
	public ResponseEntity<List<SpeciesListJson>>getSpecies(){
		return ResponseEntity.ok(speciesBusiness.getListSpecies());
	}
	
	@GetMapping(value = "/species/{id}")
	public ResponseEntity<SpeciesListJson> getSpecies(@PathVariable("id")  long id ){
		return ResponseEntity.ok(speciesBusiness.getSpeciesId(id));
	}
	
	@PutMapping("/species/update/{id}")
	public ResponseEntity<SpeciesListJson> updateSpecies(@PathVariable("id") long id,@RequestBody SpeciesPayload payload) {
		Optional<Species> speciesData = speciesService.finOptionalById(id);
		if (speciesData.isPresent()) {
			speciesBusiness.updateSpecies(speciesData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/species/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id){
		try {
			speciesBusiness.deleteSpecies(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
