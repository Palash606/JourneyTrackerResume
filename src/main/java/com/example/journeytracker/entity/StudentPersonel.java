package com.example.journeytracker.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StudentPersonel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String scholarNo;

    private String studentName;

    private String studentPassword;

    private String gender;

    private String studentDept;

    private Integer studentSemester;

    private Integer studentSection;

    @Column(unique = true)
    private String studentCollegeEmail;

    @Column(unique = true)
    private String studentPersonalEmail;

    @Column(unique = true)
    private String studentGithub;

    @Column(unique = true)
    private String studentLinkedin;

    private String studentAddress;

    @Column(unique = true)
    private String studentPhone;

    @Column(unique = true)
    private String studentEnrollmentNo;

    private String studentPhoto;

    private String studentCategory;

    private Integer admissonYear;

    private String Dob;

    @OneToMany(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private List<Achievement> getAllAchievements;

    @OneToOne(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private Career career;

    @OneToOne(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private AcademicDetails academic;

    @OneToMany(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private List<Certificate> getAllCertificate;

    @OneToMany(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private List<Curricular> getAllCurricular;

    @OneToMany(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private List<Internship> getAllInternship;

    @OneToMany(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private List<Project> getAllProject;

    @OneToMany(mappedBy = "scholarNo", cascade = CascadeType.ALL)
    private List<Skill> getAllSkill;


    public StudentPersonel() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScholarNo() {
        return scholarNo;
    }

    public void setScholarNo(String scholarNo) {
        this.scholarNo = scholarNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentDept() {
        return studentDept;
    }

    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public Integer getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(Integer studentSemester) {
        this.studentSemester = studentSemester;
    }

    public Integer getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(Integer studentSection) {
        this.studentSection = studentSection;
    }

    public String getStudentCollegeEmail() {
        return studentCollegeEmail;
    }

    public void setStudentCollegeEmail(String studentCollegeEmail) {
        this.studentCollegeEmail = studentCollegeEmail;
    }

    public String getStudentPersonalEmail() {
        return studentPersonalEmail;
    }

    public void setStudentPersonalEmail(String studentPersonalEmail) {
        this.studentPersonalEmail = studentPersonalEmail;
    }

    public String getStudentGithub() {
        return studentGithub;
    }

    public void setStudentGithub(String studentGithub) {
        this.studentGithub = studentGithub;
    }

    public String getStudentLinkedin() {
        return studentLinkedin;
    }

    public void setStudentLinkedin(String studentLinkedin) {
        this.studentLinkedin = studentLinkedin;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEnrollmentNo() {
        return studentEnrollmentNo;
    }

    public void setStudentEnrollmentNo(String studentEnrollmentNo) {
        this.studentEnrollmentNo = studentEnrollmentNo;
    }

    public String getStudentPhoto() {
        return studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
    }

    public String getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(String studentCategory) {
        this.studentCategory = studentCategory;
    }

    public Integer getAdmissonYear() {
        return admissonYear;
    }

    public void setAdmissonYear(Integer admissonYear) {
        this.admissonYear = admissonYear;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public List<Achievement> getGetAllAchievements() {
        return getAllAchievements;
    }

    public void setGetAllAchievements(List<Achievement> getAllAchievements) {
        this.getAllAchievements = getAllAchievements;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public AcademicDetails getAcademic() {
        return academic;
    }

    public void setAcademic(AcademicDetails academic) {
        this.academic = academic;
    }

    public List<Certificate> getGetAllCertificate() {
        return getAllCertificate;
    }

    public void setGetAllCertificate(List<Certificate> getAllCertificate) {
        this.getAllCertificate = getAllCertificate;
    }

    public List<Curricular> getGetAllCurricular() {
        return getAllCurricular;
    }

    public void setGetAllCurricular(List<Curricular> getAllCurricular) {
        this.getAllCurricular = getAllCurricular;
    }

    public List<Internship> getGetAllInternship() {
        return getAllInternship;
    }

    public void setGetAllInternship(List<Internship> getAllInternship) {
        this.getAllInternship = getAllInternship;
    }

    public List<Project> getGetAllProject() {
        return getAllProject;
    }

    public void setGetAllProject(List<Project> getAllProject) {
        this.getAllProject = getAllProject;
    }

    public List<Skill> getGetAllSkill() {
        return getAllSkill;
    }

    public void setGetAllSkill(List<Skill> getAllSkill) {
        this.getAllSkill = getAllSkill;
    }


}
