package com.example.journeytracker.payloads;

import java.util.Date;

public class CertificateDto {

    private Integer id;
    private StudentPersonelDto scholarNo;
    private String certiName;
    private String certiPlateform;
    private Date compleDate;
    private String certiUrl;

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

    public String getCertiName() {
        return certiName;
    }

    public void setCertiName(String certiName) {
        this.certiName = certiName;
    }

    public String getCertiPlateform() {
        return certiPlateform;
    }

    public void setCertiPlateform(String certiPlateform) {
        this.certiPlateform = certiPlateform;
    }

    public Date getCompleDate() {
        return compleDate;
    }

    public void setCompleDate(Date compleDate) {
        this.compleDate = compleDate;
    }

    public String getCertiUrl() {
        return certiUrl;
    }

    public void setCertiUrl(String certiUrl) {
        this.certiUrl = certiUrl;
    }

    public CertificateDto() {
        // TODO Auto-generated constructor stub
    }


}
