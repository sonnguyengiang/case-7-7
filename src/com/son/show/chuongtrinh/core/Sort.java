package com.son.show.chuongtrinh.core;

import com.son.show.chuongtrinh.sapxep.SortByType;
import com.son.show.chuongtrinh.sapxep.SortDown;
import com.son.show.chuongtrinh.sapxep.SortUp;
import com.son.show.file.DocFile;
import com.son.nhanvien.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    DocFile<Staff> docFile = new DocFile<>();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Staff> list = docFile.docFile("qlnv.txt");
    //sắp xếp
    public void menuSort() {
        System.out.println("1. Sắp xếp theo id từ thấp đến cao");
        System.out.println("2. sắp xếp theo id từ cao xuống thấp");
        System.out.println("3. Phân loại nhân viên");
        System.out.println("4. Quay lại");
        System.out.print("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                sortUp();
                break;
            case 2:
                sortDown();
                break;
            case 3:
                sortSaffByType();
                break;
            case 4:
                break;
        }
    }

    private void sortUp() {
        SortUp sortUp = new SortUp();
        Collections.sort(list, sortUp);
    }

    private void sortDown() {
        SortDown sortDown = new SortDown();
        Collections.sort(list, sortDown);
    }

    private void sortSaffByType() {
        SortByType sortByType = new SortByType();
        Collections.sort(list, sortByType);
    }
}
