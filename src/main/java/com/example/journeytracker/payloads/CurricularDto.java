package com.example.journeytracker.payloads;

public class CurricularDto {

	private Integer id;
	private StudentPersonelDto scholarNo;
	private String curriName;
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
	public String getCurriName() {
		return curriName;
	}
	public void setCurriName(String curriName) {
		this.curriName = curriName;
	}
	public CurricularDto() {
		// TODO Auto-generated constructor stub
	}
	
	

}
