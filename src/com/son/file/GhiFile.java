package com.son.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GhiFile<T> {

    public void ghiFile(String filePath, ArrayList<T> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
        }
    }
}
