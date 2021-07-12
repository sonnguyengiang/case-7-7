package com.son.show.chuongtrinh.core;

import com.son.nhanvien.Staff;
import com.son.show.file.DocFile;

import java.util.ArrayList;
import java.util.Scanner;


public class Find {
    private DocFile<Staff> docFile = new DocFile<>();
    private Scanner scanner = new Scanner(System.in);

    public void findByAlphabet() {
        ArrayList<Staff> list = docFile.docFile("qlnv.txt");
        ArrayList<Integer> saveIndex = new ArrayList<>();
        System.out.print("        Nhập 1 chữ cái có trong tên: ");
        String alphabet = scanner.nextLine();
        ArrayList<String> listName = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i).getName().split(" ");
            String nameSaff = temp[temp.length - 1];
            listName.add(nameSaff);
        }
        for (int i = 0; i < listName.size(); i++) {
            String[] temp = listName.get(i).split("");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals(alphabet)) {
                    saveIndex.add(i);
                }
            }
        }
        for (int i = 0; i < saveIndex.size(); i++) {
            System.out.println(list.get(saveIndex.get(i)));
        }

    }

    public void findByname() {
        ArrayList<Staff> list = docFile.docFile("qlnv.txt");
        ArrayList<Integer> saveIndex = new ArrayList<>();
        System.out.print("        Nhập tên cần tìm: ");
        String name = scanner.nextLine();

        for (int i = 0; i < list.size(); i++) {
            String[] temp = list.get(i).getName().split(" ");
            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals(name)) {
                    saveIndex.add(i);
                }
            }
        }
        for (int i = 0; i < saveIndex.size(); i++) {
            System.out.println(list.get(saveIndex.get(i)));
        }
    }
}

