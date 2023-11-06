package com.example.demo.data.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Typetree;
import java.util.Optional;

@Repository
public interface TypetreeRepository  extends JpaRepository<Typetree, Long>{
	Typetree findById(long id);
	Typetree  findByName(String name);
	Optional<Typetree> findOptionalById(long id);
}
