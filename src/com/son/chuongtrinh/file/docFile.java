package com.son.chuongtrinh.file;

import com.son.nhanvien.*;

import java.io.*;
import java.util.ArrayList;

public class docFile {
    static ArrayList<Staff> list = new ArrayList<>();

    static public ArrayList<Staff> docFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("qlnv.txt"));
            list = (ArrayList<Staff>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("File hiện đang trống");
        }
        return list;
    }
}

