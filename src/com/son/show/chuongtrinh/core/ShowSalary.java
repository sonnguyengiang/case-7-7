package com.son.show.chuongtrinh.core;

import com.son.nhanvien.Staff;
import com.son.nhanvien.StaffFullTime;
import com.son.nhanvien.StaffPartTime;
import com.son.show.file.DocFile;
import com.son.show.file.GhiFile;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowSalary {
    DocFile<Staff> docFile = new DocFile<>();
    Scanner scanner = new Scanner(System.in);
    GhiFile<Staff> ghiFile = new GhiFile<>();

    public void menuSalary() {
        System.out.println("   1. hiện thị lương nhân viên FullTime");
        System.out.println("   2. hiện thị lương nhân viên PartTime");
        System.out.println("   3. quay lại");
        System.out.print("   Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                showSalarySaffFullTime();
                break;
            case 2:
                showSalarySaffPartTime();
                break;
            case 3:
                break;
        }
    }

    private void showSalarySaffFullTime() {
        ArrayList<Staff> list = docFile.docFile("qlnv.txt");
        for (Staff a : list) {
            if (a instanceof StaffFullTime) {
                System.out.println("id:" + a.getId() + " " + ((StaffFullTime)a).getName() + ": " + ((StaffFullTime)a).tinhLuong() + " VNĐ");
            }
        }
    }

    private void showSalarySaffPartTime() {
        ArrayList<Staff> list = docFile.docFile("qlnv.txt");
        for (Staff a : list) {
            if (a instanceof StaffPartTime) {
                System.out.println("id:" + a.getId() + " " +  ((StaffPartTime) a).getName() + ": " + ((StaffPartTime) a).tinhLuong() + " VNĐ");
            }
        }
    }
}
