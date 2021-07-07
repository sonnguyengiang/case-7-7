package com.son;


import com.son.file.DocFile;
import com.son.login.data.ManagerAccount;
import com.son.nhanvien.Staff;

public class Main {
    public static void main(String[] args) {
//        Menu menu = new Menu();
//        menu.client();
//        ManagerAccount managerAccount = new ManagerAccount();
//        managerAccount.show();

        DocFile<Staff> docFile = new DocFile();
        docFile.docFile("abc.txt");

    }
}
