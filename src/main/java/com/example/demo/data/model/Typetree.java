package com.example.demo.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Typetree")
@Table(
		name="typetree")
public class Typetree {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name ="name",nullable  = false)
	private String name;
	
	public Typetree() {
		;
	}

	public Typetree(String name) {
		super();
		this.name = name;
	}
	
}
