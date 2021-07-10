package com.son.nhanvien;

import java.io.Serializable;

public class Staff implements Serializable{
    private int id;
    private String name;
    private String gender;
    private int age;
    private String gmail;
    private String phonenumber;
    private String address;
    private String status;
    private double salary;

    public Staff() {
    }

    public Staff(int id, String name, String gender, int age, String gmail, String phonenumber, String address, String status, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.gmail = gmail;
        this.phonenumber = phonenumber;
        this.address = address;
        this.status = status;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", gender='" + gender + '\'' +
                        ", age=" + age + '\'' +
                        ", gmail=" + gmail + '\'' +
                        ", phonenumber=" + phonenumber + '\'' +
                        ", address='" + address + '\'' +
                        ", status='" + status + '\'' +
                        ", salary=" + salary;
    }
    public String typeSaff(){
        return "";
    }
}