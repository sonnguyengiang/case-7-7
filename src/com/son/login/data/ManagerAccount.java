package com.son.login.data;

import com.son.chuongtrinh.ProgramMenu;
import com.son.login.Login;
import com.son.login.data.file.CreateFilePass;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    ArrayList<Login> list = CreateFilePass.docFileAccount("D:\\java\\modun2\\case study\\account.txt");
    ProgramMenu programMenu = new ProgramMenu();
    Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println(list.size());
        for (Login l : list) {
            System.out.println(l);
        }
    }

    public void login() {
        System.out.print("Nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        checkAccount(account, password);
    }

    private void checkAccount(String account, String password) {
        ArrayList<Login> arrayList = CreateFilePass.docFileAccount("D:\\java\\modun2\\case study\\account.txt");
        int check = -1;
        if (arrayList.size() == 0) {
            System.out.println("ứng dụng này hiện tại chưa có ai đăng kí ...\n");
        } else {
            for (Login login : arrayList) {
                if (login.getAccount().equals(account) && login.getPassword().equals(password)) {
                    System.out.println("Đăng nhập thành công ...\n");
                    programMenu.menu();
                    return;
                } else {
                    check = 1;
                }
            }
            if (check > 0){
                System.out.println("tài khoản hoặc mật khẩu không chính xác ...\n");
            }
        }
    }

    public void createNewAccount() {
        ArrayList<Login> arrayList = CreateFilePass.docFileAccount("D:\\java\\modun2\\case study\\account.txt");
        System.out.print("Nhập tên người dùng: ");
        String username = scanner.nextLine();
        System.out.print("Nhập tài khoản: ");
        String account = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        int check = -1;
        if (arrayList.size() == 0) {
            arrayList.add(new Login(username, account, password));
            System.out.println("Thêm thành công ...\n");
            CreateFilePass.ghiFileAccount("D:\\java\\modun2\\case study\\account.txt", arrayList);
        } else {
            for (Login login : arrayList) {
                if (!login.getAccount().equals(account)) {
                    System.out.println("Tài khoản đã tồn tại ...\n");
                    return;
                } else {
                    check = 1;
                }
            }
            if (check > 0) {
                arrayList.add(new Login(username, account, password));
                System.out.println("Thêm thành công ...\n");
                CreateFilePass.ghiFileAccount("D:\\java\\modun2\\case study\\account.txt", arrayList);
            }
        }
    }
}
