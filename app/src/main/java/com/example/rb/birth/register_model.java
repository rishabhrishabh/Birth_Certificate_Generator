package com.example.rb.birth;

public class register_model {
    String registration,phone,name,father,place;
  public register_model()
  {

  }
    public register_model(String registration, String phone, String name, String father, String place) {
        this.registration = registration;
        this.phone = phone;
        this.name = name;
        this.father = father;
        this.place = place;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
