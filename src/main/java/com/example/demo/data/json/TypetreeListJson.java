package com.example.demo.data.json;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.data.model.Typetree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TypetreeListJson {
	private long id; 
	private String name;
	
	public static TypetreeListJson packJson(Typetree typetree) {
			
			TypetreeListJson ptlj =new TypetreeListJson();
			ptlj.setId(typetree.getId());
			ptlj.setName(typetree.getName());;
			
			return ptlj;
		}
	public static List<TypetreeListJson> packJsons(List<Typetree> typetrees){
		List<TypetreeListJson> typetreeListJsons =new ArrayList<TypetreeListJson>();
		for (Typetree typetree : typetrees) {
			typetreeListJsons.add(packJson(typetree));
		}
		return typetreeListJsons;
	}	

}
