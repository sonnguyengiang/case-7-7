package com.son.chuongtrinh.fail;

public class IdFail extends Exception{
    @Override
    public String getMessage() {
        return "id bị trùng";
    }
}
