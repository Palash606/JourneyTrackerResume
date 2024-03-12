package com.example.journeytracker.entity;

import jakarta.persistence.*;

@Entity
public class AcademicDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private StudentPersonel scholarNo;
	
	
	
	
}
