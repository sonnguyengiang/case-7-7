package com.son.show.chuongtrinh;


import com.son.show.Display;
import com.son.show.chuongtrinh.core.*;
import com.son.show.login.data.ManagerAccount;
import com.son.show.login.data.ManagerUser;
import com.son.nhanvien.Staff;

import java.util.Scanner;

public class ProgramMenu {
    static Scanner scanner = new Scanner(System.in);
    static PushSaff manager = new PushSaff();
    static ManagerUser managerUser = new ManagerUser();
    static Sort sort = new Sort();
    static Show show = new Show();
    static FindByName findByName = new FindByName();
    static Status status = new Status();
    static Remove remove = new Remove();
    static ShowSalary showSalary = new ShowSalary();
    static UpdateSaff updateSaff = new UpdateSaff();
    static Find find = new Find();
    static Display display = new Display();

    static public void menuAdmin() {
        while (true) {
            try {
                while (true) {
                    System.out.println("-----------Menu-----------");
                    System.out.println(" 1. Thêm nhân viên");
                    System.out.println(" 2. Tìm kiếm nhân viên");
                    System.out.println(" 3. Kiểm tra trạng thái nhân viên");
                    System.out.println(" 4. Sửa thông tin của nhân viên");
                    System.out.println(" 5. Thay đổi trạng thái của nhân viên");
                    System.out.println(" 6. hiện thị toàn bộ thông tin");
                    System.out.println(" 7. Sắp xếp Nhân viên");
                    System.out.println(" 8. xóa nhân viên");
                    System.out.println(" 9. hiện thị lương nhân viên");
                    System.out.println(" 0. Exit");
                    System.out.print(" Nhập lựa chọn: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("     1. Thêm nhân viên fulltime");
                            System.out.println("     2. Thêm nhân viên parttime");
                            System.out.println("     3. Back");
                            System.out.print("       nhập lựa chọn: ");
                            int choose = Integer.parseInt(scanner.nextLine());
                            if (choose == 1) {
                                Staff staff = manager.create("full");
                                manager.addList(staff);
                                break;
                            } else if (choose == 2) {
                                Staff staff1 = manager.create("part");
                                manager.addList(staff1);
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            System.out.println("     1. Tìm nhân viên theo tên");
                            System.out.println("     2. tìm nhân viên thao chữ cái");
                            System.out.println("     3. Back");
                            System.out.print("     nhập lựa chọn: ");
                            int choose1 = Integer.parseInt(scanner.nextLine());
                            if (choose1 == 1) {
                                find.findByname();
                                break;
                            } else if (choose1 == 2) {
                                find.findByAlphabet();
                                break;
                            } else {
                                break;
                            }
//                            findByName.findByName(manager);
//                            break;
                        case 3:
                            status.checkStatus(manager);
                            break;
                        case 4:
                            updateSaff.updateNhanVien(manager);
                            break;
                        case 5:
                            status.editStatus(manager);
                            break;
                        case 6:
                            show.showList(manager);
                            break;
                        case 7:
                            manager.menuSort();
                            break;
                        case 8:
                            remove.remove(manager);
                            break;
                        case 9:
                            showSalary.menuSalary();
                            break;
                        case 0:
                            System.out.println("\n");
                            display.client();
                            break;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    static public void menuSaff() {
        while (true) {
            try {
                while (true) {
                    System.out.println("-----------Menu-----------");
                    System.out.println(" 1. Tìm kiếm nhân viên");
                    System.out.println(" 2. Kiểm tra trạng thái nhân viên");
                    System.out.println(" 3. Thông tin tài khoản");
                    System.out.println(" 4. hiện thị toàn bộ thông tin");
                    System.out.println(" 5. Sắp xếp Nhân viên");
                    System.out.println(" 6. hiện thị lương nhân viên");
                    System.out.println(" 0. Exit");
                    System.out.print(" Nhập lựa chọn: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("     1. Tìm nhân viên theo tên");
                            System.out.println("     2. tìm nhân viên thao chữ cái");
                            System.out.println("     3. Back");
                            System.out.print("     nhập lựa chọn: ");
                            int choose1 = Integer.parseInt(scanner.nextLine());
                            if (choose1 == 1) {
                                find.findByname();
                                break;
                            } else if (choose1 == 2) {
                                find.findByAlphabet();
                                break;
                            } else {
                                break;
                            }
//                            findByName.findByName(manager);
//                            break;
                        case 2:
                            status.checkStatus(manager);
                            break;
                        case 3:
                            managerUser.MenuUser();
                            break;
                        case 4:
                            show.showList(manager);
                            break;
                        case 5:
                            manager.menuSort();
                            break;
                        case 6:
                            showSalary.menuSalary();
                            break;
                        case 0:
                            System.out.println("\n");
                            display.client();
                            break;

                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
