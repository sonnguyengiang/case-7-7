package com.son.show.chuongtrinh.core;

import com.son.nhanvien.Staff;

import java.util.ArrayList;

public class Show {
    public void showList(PushSaff manager){
        ArrayList<Staff> list = manager.list;
        if (list.size() == 0){
            System.out.println("danh sách đang trống");
        } else {
            for (Staff staff : list) {
                System.out.println(staff);
            }
        }
    }
}
