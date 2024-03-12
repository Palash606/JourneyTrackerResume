package com.example.journeytracker.entity;

import jakarta.persistence.*;

@Entity
public class Curricular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private StudentPersonel scholarNo;
    private String curriName;

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

    public String getCurriName() {
        return curriName;
    }

    public void setCurriName(String curriName) {
        this.curriName = curriName;
    }

    public Curricular() {
        // TODO Auto-generated constructor stub
    }


}
