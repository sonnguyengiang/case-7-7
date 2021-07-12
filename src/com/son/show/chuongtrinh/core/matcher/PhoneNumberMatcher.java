package com.son.show.chuongtrinh.core.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberMatcher{
    private static  Pattern pattern;
    private Matcher matcher;

    private static final String PHONE_REGEX = "^[0]{1}+[0-9]{9}$";

    public PhoneNumberMatcher() {
        pattern = pattern.compile(PHONE_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
