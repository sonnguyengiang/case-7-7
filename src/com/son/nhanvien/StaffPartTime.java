package com.son.nhanvien;

public class StaffPartTime extends Staff {
    private int timeWork;

    public StaffPartTime(int timeWork) {
        this.timeWork = timeWork;
    }

    public StaffPartTime(int id, String name, String gender, int age, String address, String status, double salary, int timeWork) {
        super(id, name, gender, age, address, status, salary);
        this.timeWork = timeWork;
    }

    public int getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(int timeWork) {
        this.timeWork = timeWork;
    }

    public double tinhLuong() {
        double luong = super.getSalary() * timeWork;
        return luong;
    }

    @Override
    public String toString() {
        return "StaffPartTime{" + super.toString() +
                " timeWork=" + timeWork +
                '}';
    }

    public String typeSaff(){
        return "StaffPartTime";
    }
}
