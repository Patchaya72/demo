package com.example.demo.data.json;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.data.model.Species;
import com.example.demo.data.model.Typetree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SpeciesListJson {
	private Long id;
	private String name;
	private Typetree  tpId;
	
	public static SpeciesListJson packJson(Species species) {
		
		SpeciesListJson ulj =new SpeciesListJson();
		ulj.setId(species.getId());
		ulj.setName(species.getName());
		ulj.setTpId(species.getTpId());
		
		return ulj;
	}
	public static List<SpeciesListJson> packJsons(List<Species> speciess){
		List<SpeciesListJson> speciesListJson =new ArrayList<SpeciesListJson>();
		for (Species species : speciess) {
			speciesListJson.add(packJson(species));
		}
		return speciesListJson;
	}
}
