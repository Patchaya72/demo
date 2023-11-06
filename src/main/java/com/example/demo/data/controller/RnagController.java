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

import com.example.demo.data.business.RangBusiness;
import com.example.demo.data.json.RangListJson;
import com.example.demo.data.model.Rang;
import com.example.demo.data.payload.RangPayload;
import com.example.demo.data.service.RangService;

@RestController
@RequestMapping("/api")
public class RnagController {
	@Autowired
	RangService rangService;
	
	@Autowired
	RangBusiness rangBusiness;
	
	public RnagController(RangService rangService) {
		this.rangService = rangService;
	}

	@PostMapping(value = "/Rang")
	public ResponseEntity<Void> saveRang(@RequestBody RangPayload payload){
		rangBusiness.saveRang(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/Rang")
	public ResponseEntity<List<RangListJson>> getAllRang(){
		return ResponseEntity.ok(rangBusiness.getListRang());
	}
	
	@GetMapping(value = "/Rang/{id}")
	public ResponseEntity<RangListJson> getRangById(@PathVariable("id")  long id ){
		return ResponseEntity.ok(rangBusiness.getRangId(id));
	}
	
	@PutMapping("/Rang/update/{id}")
	public ResponseEntity<RangListJson> updateRang(@PathVariable("id") long id,@RequestBody RangPayload payload) {
		Optional<Rang> rangData = rangService.finOptionalById(id);
		if (rangData.isPresent()) {
			rangBusiness.updateRang(rangData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/Rang/{id}")
	public ResponseEntity<HttpStatus> deleteRang(@PathVariable("id") long id){
		try {
			rangBusiness.deleteRang(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
