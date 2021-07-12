package com.son.show.login.data;

import com.son.nhanvien.Staff;
import com.son.show.chuongtrinh.core.FindByName;
import com.son.show.chuongtrinh.core.PushSaff;
import com.son.show.chuongtrinh.core.Remove;
import com.son.show.chuongtrinh.core.UpdateSaff;
import com.son.show.file.DocFile;
import com.son.show.file.GhiFile;
import com.son.show.login.Login;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginByAdmin {
    private DocFile<Login> docFile = new DocFile<>();
    private GhiFile<Login> ghiFile = new GhiFile<>();
    private File file = new File("AccountAdmin.txt");
    static Scanner scanner = new Scanner(System.in);

    static PushSaff manager = new PushSaff();
    static FindByName findByName = new FindByName();
    static Remove remove = new Remove();
    static UpdateSaff updateSaff = new UpdateSaff();

    public LoginByAdmin() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            creatAccountAdmin();
        }
    }
    private void creatAccountAdmin() {
        final ArrayList<Login> list = new ArrayList<>();
        list.add(new Login("admin","adimin"));
    }

}
