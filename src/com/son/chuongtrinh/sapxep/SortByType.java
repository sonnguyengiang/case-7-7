package com.son.chuongtrinh.sapxep;

import com.son.nhanvien.Staff;

import java.util.Comparator;

public class SortByType implements Comparator<Staff> {

    @Override
    public int compare(Staff o1, Staff o2) {
        return o1.typeSaff().compareTo(o2.typeSaff());
    }
}
