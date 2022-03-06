package com.jpay.customer.phone.number.common;

public class Constants {

    private Constants() {

    }

    public static final String CAMEROON_REGEX = "\\(237\\)\\ ?[2368]\\d{7,8}$";
    public static final String ETHIOPIA_REGEX = "\\(251\\)\\ ?[1-59]\\d{8}$";
    public static final String MOROCOO_REGEX = "\\(212\\)\\ ?[5-9]\\d{8}$";
    public static final String MOZAMBIQUE_REGEX = "\\(258\\)\\ ?[28]\\d{7,8}$";
    public static final String UGANDA_REGEX = "\\(256\\)\\ ?\\d{9}$";

    public static final String CAMEROON_COUNTRY_CODE = "237";
    public static final String ETHIOPIA_COUNTRY_CODE = "251";
    public static final String MOROCOO_COUNTRY_CODE = "212";
    public static final String MOZAMBIQUE_COUNTRY_CODE = "258";
    public static final String UGANDA_COUNTRY_CODE = "256";

    public static final String VALID = "VALID";
    public static final String NOT_VALID = "NOTVALID";

}
