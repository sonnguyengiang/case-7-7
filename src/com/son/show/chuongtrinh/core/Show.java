package com.son.show.chuongtrinh.core;

import com.son.show.file.DocFile;
import com.son.nhanvien.Staff;

import java.util.ArrayList;

public class Show {
    DocFile<Staff> docFile = new DocFile<>();
    public void showList(PushAndChangeSaff manager){
        ArrayList<Staff> list = manager.list;
        for (Staff staff : list) {
            System.out.println(staff);
        }
    }
}
