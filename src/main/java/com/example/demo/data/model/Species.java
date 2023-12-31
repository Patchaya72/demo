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
@Entity(name = "Species")
@Table(
		name="species")
public class Species {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name ="Name",nullable  = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Tpid", referencedColumnName = "id",nullable = false)
	@Fetch(FetchMode.JOIN)
	private Typetree  tpId;
	
	public Species() {
		;
	}

	public Species(String name, Typetree tpId) {
		super();
		this.name = name;
		this.tpId = tpId;
	}

}
