package com.son.chuongtrinh;

import com.son.chuongtrinh.file.fail.AgeFail;
import com.son.chuongtrinh.file.fail.GenderFail;
import com.son.chuongtrinh.file.fail.IdFail;
import com.son.nhanvien.Staff;
import com.son.nhanvien.StaffFullTime;
import com.son.nhanvien.StaffPartTime;
import com.son.chuongtrinh.file.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProgram {
    ArrayList<Staff> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void show() {
        list = docFile.docFile();
        for (Staff staff : list) {
            System.out.println(staff);
        }
    }

    //tìm kiếm theo tên
    public void findByName() {
        ArrayList<Staff> list = docFile.docFile();
        System.out.print("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                System.out.println(list.get(i));
            }
        }
    }

    //Kiểm tra trạng thái của nhân viên
    public void checkStatus() {
        System.out.print("Nhập id của nhân viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Staff e : list) {
            if (e.getId() == id) {
                System.out.println(e.getName() + " hiện tại " + e.getStatus());
            }
        }
    }

    //Cập nhập
    public void editNV() {
        System.out.print("Nhập id của nhân viên cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                if (list.get(i) instanceof StaffFullTime) {
                    list.set(i, create("full"));
                    break;
                } else {
                    list.set(i, create("part"));
                    break;
                }
            }
        }
        ghiFile.ghiFile(list);
    }

    //Thay đổi trạng thái
    public void editStatus() {
        System.out.print("Nhập id của nhân viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Staff staff : list) {
            if (staff instanceof StaffFullTime) {
                String status = getStatus();
                ((StaffFullTime) staff).setStatus(status);
                break;
            }
            if (staff instanceof StaffPartTime) {
                String status = getStatus();
                ((StaffPartTime) staff).setStatus(status);
                break;
            }
        }
        ghiFile.ghiFile(list);
    }

    //Hàm tạo kiểu nhân viên<fulltime và partime>
    public Staff create(String KieuNv) {
        int id = getId();
        String name = getName();
        int age = getAge();
        String address = getAddress();
        String status = getStatus();
        String gender = getGender();
        double salary = getSalary();
        if (KieuNv.equals("full")) {
            return new StaffFullTime(id, name, gender, age, address, status, salary);
        } else {
            int hours = getHours();
            return new StaffPartTime(id, name, gender, age, address, status, salary, hours);
        }
    }

    //Thêm danh sách
    public void addList(Staff staff) {
        list.add(staff);
        ghiFile.ghiFile(list);
    }

    private String getName() {
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        return name;
    }

    private int getAge() {
        while (true) {
            try {
                System.out.print("nhập tuổi của nhân viên: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 18) {
                    throw new AgeFail();
                }
                return age;
            } catch (AgeFail e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("sai định dạng");
            }
        }
    }

    private String getGender() {
        while (true) {
            try {
                System.out.print("Nhập giới tính(Nam\\Nữ): ");
                String gender = scanner.nextLine();
                if (gender.matches("nam") || gender.matches("nu") || gender.matches("nữ")) {
                    if (gender.equals("nam")) {
                        return "Nam";
                    } else {
                        return "Nữ";
                    }
                } else {
                    throw new GenderFail();
                }
            } catch (GenderFail e) {
                e.getMessage();
            }
        }
    }

    private String getAddress() {
        System.out.print("Nhập địa chỉ của nhân viên: ");
        String address = scanner.nextLine();
        return address;
    }

    private String getStatus() {
        System.out.print("Nhập trạng thái của nhân viên(true/false): ");
        String status = scanner.nextLine();
        if (status.equals("true")) {
            return "đang đi làm";
        } else if (status.equals("false")) {
            return "đang nghỉ";
        } else
            return "chưa xác nhận";
    }

    private double getSalary() {
        while (true) {
            try {
                System.out.print("Nhập tiền lương hiện tại của nhân viên: ");
                double salary = Double.parseDouble(scanner.nextLine());
                return salary;
            } catch (Exception e) {
                System.out.println("sai dịnh dạng");
            }
        }
    }

    private int getHours() {
        while (true) {
            try {
                System.out.print("Nhập số giờ làm việc: ");
                int hours = Integer.parseInt(scanner.nextLine());
                return hours;
            } catch (Exception e) {
                System.out.println("sai định dạng");
            }
        }
    }

    private int getId() {
        while (true) {
            try {
                System.out.print("Nhập id của nhân viên(Nhập số): ");
                int id = Integer.parseInt(scanner.nextLine());
                if (list.isEmpty()) {
                    return id;
                } else {
                    for (Staff a : list) {
                        if (a.getId() == id) {
                            throw new IdFail();
                        } else {
                            return id;
                        }
                    }
                }
            } catch (IdFail e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Sai định dạng");
            }
        }
    }


    //----user----
    public void managerUser() {
        System.out.println("1. hiện thị thông tin tài khoản");
        System.out.println("2. thay đổi mật khẩu");
        System.out.println("3. exit");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
