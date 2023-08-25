package com.example;


import java.time.LocalDate;


public class Cat {    
    private String tutorName;
    private String tutorPhone;
    private String bloodType;
    private LocalDate dateOfBirth;
    private String name;
    private Boolean isCastrated;
    private Integer id; 

    public Cat() {
    }
    
    public Cat(String name, String tutorName, String tutorPhone, String bloodType, LocalDate dateOfBirth,
            Boolean isCastrated, Integer id) {
        this.name = name;
        this.tutorName = tutorName;
        this.tutorPhone = tutorPhone;
        this.bloodType = bloodType;
        this.dateOfBirth = dateOfBirth;
        this.isCastrated = isCastrated;
        this.id = id;
    }
    


    public String getName() {
        return name;
    }



    public String getTutorName() {
        return tutorName;
    }



    public String getTutorPhone() {
        return tutorPhone;
    }



    public String getBloodType() {
        return bloodType;
    }



    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }



    public Boolean getIsCastrated() {
        return isCastrated;
    }


     public Integer getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }



    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }



    public void setTutorPhone(String tutorPhone) {
        this.tutorPhone = tutorPhone;
    }



    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }



    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public void setIsCastrated(Boolean isCastrated) {
        this.isCastrated = isCastrated;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    @Override
    public String toString() {
        return "Cat [tutorName=" + tutorName + ", tutorPhone=" + tutorPhone + ", bloodType=" + bloodType
                + ", dateOfBirth=" + dateOfBirth + ", name=" + name + ", isCastrated=" + isCastrated + ", id=" + id
                + "]";
    }
  
}