package com.example.journeytracker.payloads;

public class AchievementDto {

    private Integer id;
    private StudentPersonelDto scholarNo;
    private String achieve;

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

    public String getAchieve() {
        return achieve;
    }

    public void setAchieve(String achieve) {
        this.achieve = achieve;
    }

    public AchievementDto() {
        // TODO Auto-generated constructor stub
    }


}
