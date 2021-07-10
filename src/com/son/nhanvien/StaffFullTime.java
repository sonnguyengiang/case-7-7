package com.son.nhanvien;

public class StaffFullTime extends Staff{

    public StaffFullTime() {
    }

    public StaffFullTime(int id, String name, String gender, int age, String gmail, String phonenumber, String address, String status, double salary) {
        super(id, name, gender, age, gmail, phonenumber, address, status, salary);
    }

    public double tinhLuong(){
        double luong = super.getSalary() * 8;
        return luong;
    }

    @Override
    public String toString() {
        return "StaffFullTime{" + super.toString() + "}";
    }

    public String typeSaff(){
        return "StaffFullTime";
    }
}
