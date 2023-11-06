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

import com.example.demo.data.business.TypetreeBusiness;
import com.example.demo.data.json.TypetreeListJson;
import com.example.demo.data.model.Typetree;
import com.example.demo.data.payload.TypetreePayload;
import com.example.demo.data.service.TypetreeService;

@RestController
@RequestMapping("/api")
public class TypetreeController {
	@Autowired
	TypetreeService typetreeService;
	
	@Autowired
	TypetreeBusiness typetreeBusiness;
	
	public TypetreeController(TypetreeService typetreeService) {
		this.typetreeService = typetreeService;
	}

	@PostMapping(value = "/Typetree")
	public ResponseEntity<Void> saveTypetree(@RequestBody TypetreePayload payload){
		typetreeBusiness.saveTypetree(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/Typetree")
	public ResponseEntity<List<TypetreeListJson>> getAllTypetree(){
		return ResponseEntity.ok(typetreeBusiness.getListTypetree());
	}
	
	@GetMapping(value = "/Typetree/{id}")
	public ResponseEntity<TypetreeListJson> getTypetreeById(@PathVariable("id")  long id ){
		return ResponseEntity.ok(typetreeBusiness.getTypetreeId(id));
	}
	
	@PutMapping("/Typetree/update/{id}")
	public ResponseEntity<TypetreeListJson> updateTypetree(@PathVariable("id") long id,@RequestBody TypetreePayload payload) {
		Optional<Typetree> typetreeData = typetreeService.finOptionalById(id);
		if (typetreeData.isPresent()) {
			typetreeBusiness.updateTypetree(typetreeData.get().getId(),payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/Typetree/{id}")
	public ResponseEntity<HttpStatus> deleteTypetree(@PathVariable("id") long id){
		try {
			typetreeBusiness.deleteTypetree(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
