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

import com.example.demo.data.business.UsersBusiness;
import com.example.demo.data.json.UsersListJson;
import com.example.demo.data.model.Users;
import com.example.demo.data.payload.UsersPayload;
import com.example.demo.data.service.UsersService;


@RestController
@RequestMapping("/api")
public class UsersController {
	@Autowired
	UsersService usersService;
	
	@Autowired
	UsersBusiness usersBusiness;
	
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping(value = "/users")
	public ResponseEntity<Void> saveStudent(@RequestBody UsersPayload payload){
		usersBusiness.saveUsers(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UsersListJson>>getAllUsers(){
		return ResponseEntity.ok(usersBusiness.getListUsers());
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UsersListJson> getUsersById(@PathVariable("id")  long id ){
		return ResponseEntity.ok(usersBusiness.getUsersId(id));
	}
	
	@PutMapping("/users/update/{id}")
	public ResponseEntity<UsersListJson> updateCustomer(@PathVariable("id") long id,@RequestBody UsersPayload payload) {
		Optional<Users> usersData = usersService.finOptionalById(id);
		if (usersData.isPresent()) {
			usersBusiness.updateUsers(usersData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id){
		try {
			usersBusiness.deleteUsers(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
