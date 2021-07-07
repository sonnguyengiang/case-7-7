package com.son;


import com.son.file.DocFile;
import com.son.login.Login;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Display menu = new Display();
        menu.client();
        DocFile<Login> docFile = new DocFile();
        ArrayList<Login> arrayList = docFile.docFile("D:\\java\\modun2\\case study\\account.txt");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
