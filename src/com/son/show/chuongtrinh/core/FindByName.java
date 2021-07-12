package com.son.show.chuongtrinh.core;

import com.son.nhanvien.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class FindByName {
    Scanner scanner = new Scanner(System.in);


    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    public void findByName(PushAndChangeSaff manager) {
        ArrayList<Staff> list = manager.list;
        System.out.print("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        int check = -1;
        if (list.size() == 0){
            System.out.println("Danh sách đang trống");
        } else {
            for (Staff staff : list) {
                if (staff.getName().equals(name)) {
                    System.out.println(staff);
                    check = 1;
                }
            }
            check(check, "", "Không tìm thấy");
        }
    }
}
