package com.example.journeytracker.payloads;

public class SkillDto {

	private Integer id;
	private StudentPersonelDto scholarNo;
	private String skillName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StudentPersonelDto getScholarNo() {
		return scholarNo;
	}
	public void setScholarNo(StudentPersonelDto scholarNo) {
		this.scholarNo = scholarNo;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public SkillDto() {
		// TODO Auto-generated constructor stub
	}
}
