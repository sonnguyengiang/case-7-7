package com.son.chuongtrinh.fail;

public class AgeFail extends Exception{
    @Override
    public String getMessage() {
        return "chưa đủ tuổi chop phép";
    }
}
