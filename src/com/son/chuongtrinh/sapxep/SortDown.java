package com.son.chuongtrinh.sapxep;

import com.son.nhanvien.Staff;

import java.util.Comparator;
import java.util.stream.Collector;

public class SortDown implements Comparator<Staff> {
    @Override
    public int compare(Staff o1, Staff o2) {
        if (o1.getId() < o2.getId()){
            return 1;
        } else if (o1.getId() < o2.getId()) {
            return 0;
        } else {
            return -1;
        }
    }
}
