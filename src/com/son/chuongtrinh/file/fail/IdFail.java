package com.son.chuongtrinh.file.fail;

public class IdFail extends Exception{
    @Override
    public String getMessage() {
        return "id bị trùng";
    }
}
