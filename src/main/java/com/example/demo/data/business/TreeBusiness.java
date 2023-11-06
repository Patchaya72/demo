package com.example.demo.data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.json.TreeListJson;
import com.example.demo.data.model.Tree;
import com.example.demo.data.payload.TreePayload;
import com.example.demo.data.service.TreeService;

@Service
public class TreeBusiness {
	@Autowired
	TreeService treeService;
	public List<TreeListJson>getListTree(){
		 return TreeListJson.packJsons(treeService.getAllTree());
	}
	public TreeListJson getTreeId(long id) {
		return TreeListJson.packJson(treeService.findById(id));
	}
	public TreeListJson getTreeByName(String name) {
		return TreeListJson.packJson(treeService.findByName(name));
	}
	
	public void saveTree(TreePayload std) {
		Tree tree = new Tree(
				std.getName(),
				std.getSpid(),
				std.getUid());
		treeService.save(tree);
	}
	public void updateTree(long id ,TreePayload payload) {
		Tree treeData = treeService.findById(id);
		treeData.setName(payload.getName());
		treeData.setSpid(payload.getSpid());
		treeData.setUid(payload.getUid());
	
	}
	public void deleteSpecies(long id) {
		treeService.deleteById(id);
	}
}
