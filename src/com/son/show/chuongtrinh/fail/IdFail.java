package com.son.show.chuongtrinh.fail;

public class IdFail extends Exception{
    @Override
    public String getMessage() {
        return "id bị trùng";
    }
}
