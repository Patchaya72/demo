package com.example.demo.data.json;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.data.model.Rang;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RangListJson {
	private long id;
	private String name ;
	
	public static RangListJson packJson(Rang rang) {
		RangListJson rlj =new RangListJson();
		rlj.setId(rang.getId());
		rlj.setName(rang.getName());
		
		return rlj;
	}
	public static List<RangListJson> packJsons(List<Rang> rangs){
		List<RangListJson> rangListJson =new ArrayList<RangListJson>();
		for (Rang rang : rangs) {
			rangListJson.add(packJson(rang));
		}
		return rangListJson;
	}
}
