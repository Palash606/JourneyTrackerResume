package com.example.journeytracker.payloads;

public class CareerDto {

    private Integer id;
    private StudentPersonelDto scholarNo;
    private String objective;
    private String strength1;
    private String strength2;
    private String weakness1;
    private String weakness2;
    private String hobby1;
    private String hobby2;

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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getStrength1() {
        return strength1;
    }

    public void setStrength1(String strength1) {
        this.strength1 = strength1;
    }

    public String getStrength2() {
        return strength2;
    }

    public void setStrength2(String strength2) {
        this.strength2 = strength2;
    }

    public String getWeakness1() {
        return weakness1;
    }

    public void setWeakness1(String weakness1) {
        this.weakness1 = weakness1;
    }

    public String getWeakness2() {
        return weakness2;
    }

    public void setWeakness2(String weakness2) {
        this.weakness2 = weakness2;
    }

    public String getHobby1() {
        return hobby1;
    }

    public void setHobby1(String hobby1) {
        this.hobby1 = hobby1;
    }

    public String getHobby2() {
        return hobby2;
    }

    public void setHobby2(String hobby2) {
        this.hobby2 = hobby2;
    }

    public CareerDto() {
        // TODO Auto-generated constructor stub
    }
}
