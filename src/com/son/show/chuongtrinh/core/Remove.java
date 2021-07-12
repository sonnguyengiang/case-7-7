package com.son.show.chuongtrinh.core;

import com.son.show.file.DocFile;
import com.son.show.file.GhiFile;
import com.son.nhanvien.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class Remove {
    DocFile<Staff> docFile = new DocFile<>();
    Scanner scanner = new Scanner(System.in);
    GhiFile<Staff> ghiFile = new GhiFile<>();

    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    public void remove(PushAndChangeSaff manager) {
        int check = -1;
        ArrayList<Staff> list = manager.list;
        System.out.print("Nhập id nhân viên muốn cho ra đảo: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                check = 1;
                break;
            }
        }
        check(check, "xóa thành công\n", "Không tìm thấy...\n");
        ghiFile.ghiFile("qlnv.txt", list);
    }
}
