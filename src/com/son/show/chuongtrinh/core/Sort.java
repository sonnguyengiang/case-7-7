package com.son.show.chuongtrinh.core;

import com.son.show.chuongtrinh.sapxep.SortByType;
import com.son.show.chuongtrinh.sapxep.SortDown;
import com.son.show.chuongtrinh.sapxep.SortUp;
import com.son.show.file.DocFile;
import com.son.nhanvien.Staff;
import com.son.show.file.GhiFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    Scanner scanner = new Scanner(System.in);
    PushAndChangeSaff manager = new PushAndChangeSaff();
    GhiFile<Staff> ghiFile = new GhiFile<>();
    public void menuSort() {
        System.out.println("1. Sắp xếp theo id từ thấp đến cao");
        System.out.println("2. sắp xếp theo id từ cao xuống thấp");
        System.out.println("3. Phân loại nhân viên");
        System.out.println("4. Quay lại");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                sortUp(manager);
                break;
            case 2:
                sortDown(manager);
                break;
            case 3:
                sortSaffByType(manager);
                break;
            case 4:
                break;
        }
    }

    private void sortUp(PushAndChangeSaff manager) {
        ArrayList<Staff> list = manager.list;
        SortUp sortUp = new SortUp();
        Collections.sort(list, sortUp);
        ghiFile.ghiFile("qlnv.txt",list);
    }

    private void sortDown(PushAndChangeSaff manager) {
        ArrayList<Staff> list = manager.list;
        SortDown sortDown = new SortDown();
        Collections.sort(list, sortDown);
        ghiFile.ghiFile("qlnv.txt",list);
    }

    private void sortSaffByType(PushAndChangeSaff manager) {
        ArrayList<Staff> list = manager.list;
        SortByType sortByType = new SortByType();
        Collections.sort(list, sortByType);
        ghiFile.ghiFile("qlnv.txt",list);
    }
}
