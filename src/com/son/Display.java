package com.son;

import com.son.login.data.ManagerAccount;

import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);
    ManagerAccount managerAccount = new ManagerAccount();
    public void client() {
        while (true) {
            System.out.println("1. đăng nhập");
            System.out.println("2. Tạo tài khoản mới");
            System.out.println("0. exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerAccount.login();
                    break;
                case 2:
                    managerAccount.createNewAccount();
                    break;
                case 0:
                    System.exit(0);

            }
        }
    }
}
