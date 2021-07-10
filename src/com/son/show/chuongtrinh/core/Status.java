package com.son.show.chuongtrinh.core;

import com.son.show.file.DocFile;
import com.son.show.file.GhiFile;
import com.son.nhanvien.Staff;
import com.son.nhanvien.StaffFullTime;
import com.son.nhanvien.StaffPartTime;

import java.util.ArrayList;
import java.util.Scanner;

public class Status {
    Scanner scanner = new Scanner(System.in);
    GhiFile<Staff> ghiFile = new GhiFile<>();

    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    public void checkStatus(PushAndChangeSaff manager) {
        System.out.print("Nhập id của nhân viên: ");
        ArrayList<Staff> list = manager.list;
        int id = Integer.parseInt(scanner.nextLine());
        int check = -1;
        for (Staff e : list) {
            if (e.getId() == id) {
                System.out.println(e.getName() + " hiện tại " + e.getStatus());
                check = 1;
                break;
            }
        }
        check(check, "__________\n", "Không tìm thấy...\n");
    }
    public void editStatus(PushAndChangeSaff manager) {
        ArrayList<Staff> list = manager.list;
        System.out.print("Nhập id của nhân viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        int check = -1;
        for (Staff staff : list) {
            if (staff.getId() == id) {
                if (staff instanceof StaffFullTime) {
                    String status = getStatus();
                    ((StaffFullTime) staff).setStatus(status);
                    check = 1;
                    break;
                }
                if (staff instanceof StaffPartTime) {
                    String status = getStatus();
                    ((StaffPartTime) staff).setStatus(status);
                    check = 1;
                    break;
                }
            } else {
                check = -1;
            }
        }
        check(check, "Sửa thành công...\n", "Không tìm thấy...\n");
        ghiFile.ghiFile("qlnv.txt", list);
    }
    private String getStatus() {
        while (true) {
            System.out.println("   1. đang đi làm");
            System.out.println("   2. đang nghỉ");
            System.out.println("   3. quay lại");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return "đang đi làm";
                case 2:
                    return "đang nghỉ";
                case 3:
                    System.exit(0);
            }
        }
    }
}
