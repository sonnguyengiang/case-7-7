package com.son.show.chuongtrinh.core;

import com.son.nhanvien.Staff;
import com.son.show.file.DocFile;

import java.util.ArrayList;

public class Show {
    DocFile<Staff> docFile = new DocFile<>();
    public void showList(PushAndChangeSaff manager){
        ArrayList<Staff> list = docFile.docFile("qlnv.txt");
        if (list.size() == 0){
            System.out.println("danh sách đang trống");
        } else {
            for (Staff staff : list) {
                System.out.println(staff);
            }
        }
    }
}
