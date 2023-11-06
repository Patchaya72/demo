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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "User")
@Table(
		name="user",
		uniqueConstraints = { 
				@UniqueConstraint(name = "user_email_unique",columnNames = "email")
		}
)

public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name ="username",nullable  = false)
	private String username;
	
	@Column(name ="email",nullable  = false)
	private String email;
	
	@Column(name ="password",nullable  = false)
	private String password;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rid", referencedColumnName = "id",nullable = false)
	@Fetch(FetchMode.JOIN)
	private Rang  rid;
	


	
	public Users() {
		;
	}




	public Users(String username, String email, String password, Rang rid) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.rid = rid;
	}


	


	
	
	
	
	
}
