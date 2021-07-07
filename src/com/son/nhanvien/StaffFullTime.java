package com.son.nhanvien;

public class StaffFullTime extends Staff{

    public StaffFullTime() {
    }

    public StaffFullTime(int id, String name, String gender, int age, String address, String status, double salary) {
        super(id, name, gender, age, address, status, salary);
    }

    public double tinhLuong(){
        double luong;
        return luong = getSalary() * 8;
    }

    @Override
    public String toString() {
        return "StaffFullTime{" + super.toString() + "}";
    }
}
