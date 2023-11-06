package com.example.demo.data.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Tree")
@Table(
		name="tree")

public class Tree {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name ="username",nullable  = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spid", referencedColumnName = "id",nullable = false)
	@Fetch(FetchMode.JOIN)
	private Species  spid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tid", referencedColumnName = "id",nullable = false)
	@Fetch(FetchMode.JOIN)
	private Users uid;
	
	public Tree () {
		;
	}

	public Tree(String name, Species spid, Users uid) {
		super();
		this.name = name;
		this.spid = spid;
		this.uid = uid;
	}


	
	
	
	
	
}
