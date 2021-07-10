package com.son.show.chuongtrinh.core;

import com.son.show.file.DocFile;
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
        for (Staff staff : list) {
            if (staff.getName().equals(name)) {
                System.out.println(staff);
                check = 1;
            }
        }
        check(check, "__________\n", "Không tìm thấy");
    }
}
