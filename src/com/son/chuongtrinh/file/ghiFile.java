package com.son.chuongtrinh.file;
import com.son.nhanvien.*;

import java.io.*;
import java.util.ArrayList;


public class ghiFile {
    static public void ghiFile(ArrayList<Staff> list){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("qlnv.txt"));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
