package com.son.chuongtrinh;


import com.son.login.data.ManagerAccount;
import com.son.login.data.ManagerUser;
import com.son.nhanvien.Staff;

import java.util.Scanner;

public class ProgramMenu {
    static Scanner scanner = new Scanner(System.in);
    static ManagerProgram manager = new ManagerProgram();
    static ManagerUser managerUser = new ManagerUser();

    static public void menu(){
        while (true){
            try{
                while (true){
                    System.out.println("-------Menu-------");
                    System.out.println("1. Thêm nhân viên");
                    System.out.println("2. Tìm kiếm nhân viên");
                    System.out.println("3. Kiểm tra trạng thái nhân viên");
                    System.out.println("4. Sửa thông tin của nhân viên");
                    System.out.println("5. Thay đổi trạng thái của nhân viên");
                    System.out.println("6. Thông tin tài khoản");
                    System.out.println("7. hiện thị toàn bộ thông tin");
                    System.out.println("8. Sắp xếp Nhân viên");
                    System.out.println("9. xóa nhân viên");
                    System.out.println("0. Exit");
                    System.out.print("Nhập lựa chọn: ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            System.out.println("     1. Thêm nhân viên fulltime");
                            System.out.println("     2. Thêm nhân viên parttime");
                            System.out.println("     3. Back");
                            int choose = Integer.parseInt(scanner.nextLine());
                            if (choose == 1){
                                Staff staff = manager.create("full");
                                manager.addList(staff);
                                break;
                            } else if (choose == 2){
                                Staff staff1 = manager.create("part");
                                manager.addList(staff1);
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            manager.findByName();
                            break;
                        case 3:
                            manager.checkStatus();
                            break;
                        case 4:
                            manager.updateNhanVien();
                            break;
                        case 5:
                            manager.editStatus();
                            break;
                        case 6:
                            managerUser.MenuUser();
                            break;
                        case 7:
                            manager.show();
                            break;
                        case 8:
                            manager.menuSort();
                            break;
                        case 9:
                            manager.remove();
                            break;
                        case 0:
                            System.exit(0);
                    }
                }
            } catch (Exception e){
            }
        }
    }
}
