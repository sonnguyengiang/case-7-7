package com.son.chuongtrinh.fail;

public class GenderFail extends Exception{
    @Override
    public String getMessage() {
        return "không xác định";
    }
}
