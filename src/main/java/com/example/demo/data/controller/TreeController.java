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

import com.example.demo.data.business.TreeBusiness;
import com.example.demo.data.json.TreeListJson;
import com.example.demo.data.model.Tree;
import com.example.demo.data.payload.TreePayload;
import com.example.demo.data.service.TreeService;

@RestController
@RequestMapping("/api")
public class TreeController {

	@Autowired
	TreeService treeService;
	
	@Autowired
	TreeBusiness treeBusiness;
	
	public TreeController(TreeService treeService) {
		this.treeService = treeService;
	}

	@PostMapping(value = "/tree")
	public ResponseEntity<Void> saveTree(@RequestBody TreePayload payload){
		treeBusiness.saveTree(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/tree")
	public ResponseEntity<List<TreeListJson>>getTree(){
		return ResponseEntity.ok(treeBusiness.getListTree());
	}
	
	@GetMapping(value = "/tree/{id}")
	public ResponseEntity<TreeListJson> getTree(@PathVariable("id")  long id ){
		return ResponseEntity.ok(treeBusiness.getTreeId(id));
	}
	
	@PutMapping("/tree/update/{id}")
	public ResponseEntity<TreeListJson> updateTree(@PathVariable("id") long id,@RequestBody TreePayload payload) {
		Optional<Tree> speciesData = treeService.finOptionalById(id);
		if (speciesData.isPresent()) {
			treeBusiness.updateTree(speciesData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/tree/{id}")
	public ResponseEntity<HttpStatus> deleteTree(@PathVariable("id") long id){
		try {
			treeBusiness.deleteSpecies(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
