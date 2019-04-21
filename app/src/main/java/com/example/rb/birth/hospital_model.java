package com.example.rb.birth;

public class hospital_model {
    String name;
    String registration_no;
    String father;
    String place;
  public hospital_model()
  {

  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration_no() {
        return registration_no;
    }

    public void setRegistration_no(String registartion_no) {
        this.registration_no = registartion_no;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
