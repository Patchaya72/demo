package com.example.demo.data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.json.RangListJson;
import com.example.demo.data.model.Rang;
import com.example.demo.data.payload.RangPayload;
import com.example.demo.data.service.RangService;

@Service
public class RangBusiness {
	@Autowired
	
	RangService rangService;
	
	public List<RangListJson> getListRang(){
		return RangListJson.packJsons(rangService.getAllRang());
	}
	public RangListJson getRangId(long id) {
		return RangListJson.packJson(rangService.findById(id));
	}
	public RangListJson getRangByName(String name) {
		return RangListJson.packJson(rangService.findByName(name));
	}
	public void saveRang(RangPayload std) {
		Rang rang = new Rang(
				std.getName());
			rangService.save(rang);
	}
	public void updateRang(long id ,RangPayload payload) {
		Rang rangData = rangService.findById(id);
		rangData.setName(payload.getName());
	
	}
	public void deleteRang(long id) {
		rangService.deleteById(id);
	}
}
