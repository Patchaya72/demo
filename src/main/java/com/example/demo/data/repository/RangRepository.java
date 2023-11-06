package com.example.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.Rang;
import java.util.Optional;



@Repository
public interface RangRepository extends JpaRepository <Rang,Long>{
	Rang findById(long id);
	Rang  findByName(String name);
	Optional<Rang> findOptionalById(long id);

}
