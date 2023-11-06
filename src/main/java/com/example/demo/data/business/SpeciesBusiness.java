package com.example.demo.data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.json.SpeciesListJson;
import com.example.demo.data.model.Species;
import com.example.demo.data.payload.SpeciesPayload;
import com.example.demo.data.service.SpeciesService;

@Service
public class SpeciesBusiness {
	@Autowired
	SpeciesService speciesService;
	public List<SpeciesListJson>getListSpecies(){
		 return SpeciesListJson.packJsons(speciesService.getAllSpecies());
	}
	public SpeciesListJson getSpeciesId(long id) {
		return SpeciesListJson.packJson(speciesService.findById(id));
	}
	public SpeciesListJson getSpeciesByName(String name) {
		return SpeciesListJson.packJson(speciesService.findByName(name));
	}
	
	public void saveSpecies(SpeciesPayload std) {
		Species species = new Species(
				std.getName(),
				std.getTpId());
		speciesService.save(species);
	}
	public void updateSpecies(long id ,SpeciesPayload payload) {
		Species speciesServiceData = speciesService.findById(id);
		speciesServiceData.setName(payload.getName());
		speciesServiceData.setTpId(payload.getTpId());
	
	}
	public void deleteSpecies(long id) {
		speciesService.deleteById(id);
	}
	
}
