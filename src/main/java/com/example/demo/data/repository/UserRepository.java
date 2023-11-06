package com.example.demo.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
	Users findById(long id);
	Users findByEmail(String email);
	Optional<Users> findOptionalById(long id);
	
}
