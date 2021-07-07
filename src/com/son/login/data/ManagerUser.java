package com.son.login.data;

import com.son.file.DocFile;
import com.son.file.GhiFile;
import com.son.login.Login;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerUser {
    DocFile<Login> docFile = new DocFile();
    GhiFile<Login> ghiFile = new GhiFile();
    Scanner scanner = new Scanner(System.in);

    public void MenuUser() {
        System.out.println("1. thay đổi mật khẩu");
        System.out.println("2. exit");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                changePass();
                break;
            case 2:
                break;
        }
    }

    public void changePass(){
        System.out.print("Nhập mật khẩu cũ: ");
        String oldPassword = scanner.nextLine();
        checkOldPassword(oldPassword);
    }
    private void checkOldPassword(String oldPassword){
        ArrayList<Login> list = docFile.docFile("D:\\java\\modun2\\case study\\account.txt");
        int check = -1;
        for (Login a: list){
            if (a.getPassword().equals(oldPassword)){
                check = 1;
                break;
            } else {
                check = -1;
            }
        }
        if (check > 0){
            createNewPassword();
        } else {
            System.out.println("Sai mật khẩu \n");
        }
    }
    private void createNewPassword(){
        System.out.print("nhập mật khẩu mới: ");
        String newPassword1 = scanner.nextLine();
        System.out.print("Nhập lại mật khẩu: ");
        String newPassword2 = scanner.nextLine();
        checkNewPassword(newPassword1,newPassword2);
    }
    private void checkNewPassword( String newPassword1, String newPassword2){
        if (newPassword1.equals(newPassword2)){
            addNewPass(newPassword1);
        } else {
            System.out.println("Không giống nhau");
        }
    }
    private void addNewPass(String newPassword){
        ArrayList<Login> list = docFile.docFile("D:\\java\\modun2\\case study\\account.txt");
        ArrayList<Login> arrayList = docFile.docFile(" AccountUsing.txt");
        String account = arrayList.get(0).getAccount();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccount().equals(account)){
                list.set(i,new Login(account,newPassword));
                System.out.println("Thay đổi thành công");
                ghiFile.ghiFile("D:\\java\\modun2\\case study\\account.txt",list);
                break;
            }
        }
    }
}
