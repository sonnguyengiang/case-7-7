package com.son.login.data.file;

import com.son.login.Login;

import java.io.*;
import java.util.ArrayList;

public class CreateFilePass {
    static public ArrayList<Login> docFileAccount(String filePath) {
        ArrayList<Login> list1 = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            list1 = (ArrayList<Login>) ois.readObject();
            ois.close();
        }
        catch (Exception e) {
        }
        return list1;
    }

    static public void ghiFileAccount(String filePath, ArrayList<Login> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
