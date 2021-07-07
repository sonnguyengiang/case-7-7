package com.son.login.data;

import com.son.chuongtrinh.ProgramMenu;
import com.son.file.DocFile;
import com.son.file.GhiFile;
import com.son.login.Login;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    private DocFile<Login> docFile = new DocFile();
    private GhiFile<Login> ghiFile = new GhiFile();
    private Scanner scanner = new Scanner(System.in);
    private String temp = "";
    public ManagerAccount() {
    }

    public void login() {
       System.out.print("Nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        checkAccount(account, password);
    }

    private void checkAccount(String account, String password) {
        ArrayList<Login> arrayList = docFile.docFile("D:\\java\\modun2\\case study\\account.txt");
        int check = -1;
        if (arrayList.size() == 0) {
            System.out.println("ứng dụng này hiện tại chưa có ai đăng kí ...\n");
        } else {
            for (Login login : arrayList) {
                if (login.getAccount().equals(account) && login.getPassword().equals(password)) {
                    temp = account;
                    System.out.println("Đăng nhập thành công ...\n");
                    pushAccountUsing();
                    ProgramMenu.menu();
                    return;
                } else {
                    check = 1;
                }
            }
            if (check > 0) {
                System.out.println("tài khoản hoặc mật khẩu không chính xác ...\n");
            }
        }
    }

    public void createNewAccount() {
        ArrayList<Login> arrayList = docFile.docFile("D:\\java\\modun2\\case study\\account.txt");
        System.out.print("Nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        int check = -1;
        if (arrayList.size() == 0) {
            arrayList.add(new Login(account, password));
            System.out.println("Thêm thành công ...\n");
            ghiFile.ghiFile("D:\\java\\modun2\\case study\\account.txt", arrayList);
        } else {
            for (Login login : arrayList) {
                if (login.getAccount().equals(account)) {
                    System.out.println("Tài khoản đã tồn tại ...\n");
                    return;
                } else {
                    check = 1;
                }
            }
            if (check > 0) {
                arrayList.add(new Login(account, password));
                System.out.println("Thêm thành công ...\n");
                ghiFile.ghiFile("D:\\java\\modun2\\case study\\account.txt", arrayList);
            }
        }
    }

    public void pushAccountUsing(){
        File file = new File("AccountUsing.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        ArrayList<Login> list = docFile.docFile("D:\\java\\modun2\\case study\\account.txt");
        ArrayList<Login> arrayList = new ArrayList<>();
        arrayList.add(new Login("1","2"));
        String passwordTemp = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccount().equals(temp)){
                passwordTemp = list.get(i).getPassword();
                break;
            }
        }
        arrayList.set(0,new Login(temp,passwordTemp));
        ghiFile.ghiFile("AccountUsing.txt",arrayList);
    }
}
