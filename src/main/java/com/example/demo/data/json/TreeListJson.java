package com.example.demo.data.json;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.data.model.Species;
import com.example.demo.data.model.Tree;
import com.example.demo.data.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TreeListJson {
	private Long id;
	private String username;
	private Species  spid;
	private Users uid;
	
public static TreeListJson packJson(Tree tree) {
		
	TreeListJson tlj =new TreeListJson();
		tlj.setId(tree.getId());
		tlj.setUsername(tree.getName());
		tlj.setSpid(tree.getSpid());
		tlj.setUid(tree.getUid());
		
		return tlj;
	}
	public static List<TreeListJson> packJsons(List<Tree> trees){
		List<TreeListJson> treeListJson =new ArrayList<TreeListJson>();
		for (Tree tree : trees) {
			treeListJson.add(packJson(tree));
		}
		return treeListJson;
}
}
