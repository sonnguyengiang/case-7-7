package com.son.file;

import com.son.nhanvien.Staff;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class DocFile<T> {
    ArrayList<T> list = new ArrayList<>();

    public ArrayList<T> docFile(String filePath){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            list = (ArrayList<T>) ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}