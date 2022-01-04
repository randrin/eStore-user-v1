package com.eStore.bear.user.utils;

public class UserConstants {

    public static final String USER_NAME = "User name is required";
    public static final String USER_EMAIL = "User email is required";
    public static final String USER_EMAIL_VALID = "Please enter the valid email";
    public static final String USER_PHONE = "User phone is required";
    public static final String USER_PHONE_VALID = "Please enter the valid phone";
    public static final String USER_PASSWORD = "User password is required";

    public static final String PATTERN_EMAIL = "^([a-zA-Z0-9_-]{4,20})@([a-zA-Z]{3,6})\\.([a-zA-Z]{2,5})$";
    public static final String PATTERN_PHONE = "^([+]\\d{2})?\\d{10}$";
    public static final String PATTERN_PASSWORD = "^(?=.*\\d).{4,12}$";
}
