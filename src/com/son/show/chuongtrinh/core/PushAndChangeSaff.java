package com.son.show.chuongtrinh.core;

import com.son.show.chuongtrinh.core.matcher.GmailMatcher;
import com.son.show.chuongtrinh.core.matcher.PhoneNumberMatcher;
import com.son.show.chuongtrinh.fail.AgeFail;
import com.son.show.chuongtrinh.fail.GenderFail;
import com.son.show.chuongtrinh.fail.IdFail;
import com.son.show.file.DocFile;
import com.son.show.file.GhiFile;
import com.son.nhanvien.Staff;
import com.son.nhanvien.StaffFullTime;
import com.son.nhanvien.StaffPartTime;

import java.util.ArrayList;
import java.util.Scanner;

public class PushAndChangeSaff {
    Scanner scanner = new Scanner(System.in);
    DocFile<Staff> docFile = new DocFile();
    GhiFile<Staff> ghiFile = new GhiFile();
    ArrayList<Staff> list = docFile.docFile("qlnv.txt");

    //kiểm tra điều điện
    private void check(int check, String a, String b) {
        if (check > 0) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    //Hàm tạo kiểu nhân viên<fulltime và partime>
    public Staff create(String KieuNv) {
        int id = getId();
        String name = getName();
        int age = getAge();
        String gmail = getGmail();
        String phonenumber = getPhoneNumber();
        String address = getAddress();
        String status = getStatus();
        String gender = getGender();
        double salary = getSalary();
        if (KieuNv.equals("full")) {
            return new StaffFullTime(id, name, gender, age, gmail, phonenumber, address, status, salary);
        } else {
            int hours = getHours();
            return new StaffPartTime(id, name, gender, age, gmail, phonenumber, address, status, salary, hours);
        }
    }

    //Cập nhập
    public void updateNhanVien(PushAndChangeSaff manager) {
        System.out.print("Nhập id của nhân viên cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int check = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                if (list.get(i) instanceof StaffFullTime) {
                    list.set(i, create("full"));
                    check = 1;
                    break;
                } else {
                    list.set(i, create("part"));
                    check = 1;
                    break;
                }
            } else {
                check = -1;
            }
        }
        check(check, "Update thành công", "Không tìm thấy nhân viên");
        ghiFile.ghiFile("qlnv.txt", list);
    }

    //Thêm danh sách
    public void addList(Staff staff) {
        list.add(staff);
        ghiFile.ghiFile("qlnv.txt", list);
    }

    private String getGmail() {
        while (true) {
            int check = -1;
            GmailMatcher gmailMatcher = new GmailMatcher();
            System.out.print("Nhập gmail: ");
            String gmail = scanner.nextLine();
            if (gmailMatcher.validate(gmail) == true) {
                if (list.size() == 0){
                    return gmail;
                } else {
                    for (Staff a : list) {
                        if (a.getGmail().equals(gmail)) {
                            check = -1;
                            break;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0) {
                        return gmail;
                    } else {
                        System.out.println("gmail bị trùng");
                    }
                }
            } else {
                System.out.println("Nhập lại");
            }
        }
    }

    private String getPhoneNumber() {
        while (true) {
            int check = -1;
            PhoneNumberMatcher phoneNumberMatcher = new PhoneNumberMatcher();
            System.out.print("Nhập số điện thoại: ");
            String phonenumber = scanner.nextLine();
            if (phoneNumberMatcher.validate(phonenumber) == true) {
                if (list.size()==0){
                    return phonenumber;
                }else {
                    for (Staff a : list) {
                        if (a.getPhonenumber().equals(phonenumber)) {
                            check = -1;
                        } else {
                            check = 1;
                        }
                    }
                    if (check > 0){
                        return phonenumber;
                    } else {
                        System.out.println("số điện thoại bị trùng");
                    }

                }
            } else {
                System.out.println("Nhập lại");
            }
        }
    }

    private String getName() {
        System.out.print("Nhập tên nhân viên: ");
        return scanner.nextLine();
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
        return scanner.nextLine();
    }

    private String getStatus() {
        while (true) {
            System.out.println("   1. đang đi làm");
            System.out.println("   2. đang nghỉ");
            System.out.println("   3. quay lại");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return "đang đi làm";
                case 2:
                    return "đang nghỉ";
                case 3:
                    System.exit(0);
            }
        }
    }

    private double getSalary() {
        while (true) {
            try {
                System.out.print("Nhập tiền lương hiện tại của nhân viên: ");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("sai dịnh dạng");
            }
        }
    }

    private int getHours() {
        while (true) {
            try {
                System.out.print("Nhập số giờ làm việc: ");
                return Integer.parseInt(scanner.nextLine());
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
                        }
                    }
                    return id;
                }
            } catch (IdFail e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Sai định dạng");
            }
        }
    }

}
