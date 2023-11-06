package com.example.demo.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Tree;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {
	Tree findById(long id);
	Tree findByName(String name) ;
	Optional<Tree> findOptionalById(long id);

}
