package com.example.demo.data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.json.TypetreeListJson;
import com.example.demo.data.model.Typetree;
import com.example.demo.data.payload.TypetreePayload;
import com.example.demo.data.service.TypetreeService;

@Service
public class TypetreeBusiness {
	@Autowired
	TypetreeService typetreeService;
	
	public List<TypetreeListJson> getListTypetree(){
		return TypetreeListJson.packJsons(typetreeService.getAllTypetree());
	}
	public TypetreeListJson getTypetreeId(long id) {
		return TypetreeListJson.packJson(typetreeService.findById(id));
	}
	public TypetreeListJson getTypetreeByName(String name) {
		return TypetreeListJson.packJson(typetreeService.findByName(name));
	}
	public void saveTypetree(TypetreePayload std) {
		Typetree typetree = new Typetree(
				std.getName());
		typetreeService.save(typetree);
	}
	public void updateTypetree(long id ,TypetreePayload payload) {
		Typetree typetreeData = typetreeService.findById(id);
		typetreeData.setName(payload.getName());
	
	}
	public void deleteTypetree(long id) {
		typetreeService.deleteById(id);
	}
}
