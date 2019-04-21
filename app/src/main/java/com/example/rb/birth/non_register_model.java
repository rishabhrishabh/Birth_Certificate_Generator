package com.example.rb.birth;

public class non_register_model {
    String phone,name,father,place;
    public non_register_model()
    {


    }

    public non_register_model(String phone, String name, String father, String place) {
        this.phone = phone;
        this.name = name;
        this.father = father;
        this.place = place;
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
