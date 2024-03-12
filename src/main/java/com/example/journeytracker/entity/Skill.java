package com.example.journeytracker.entity;

import jakarta.persistence.*;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private StudentPersonel scholarNo;
	private String skillName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StudentPersonel getScholarNo() {
		return scholarNo;
	}
	public void setScholarNo(StudentPersonel scholarNo) {
		this.scholarNo = scholarNo;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public Skill() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
