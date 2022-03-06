package com.jpay.customer.phone.number.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.jpay.customer.phone.number.common.Constants;

/**
 * validate phone numbers based on country
 * 
 * @author hmahmoud2
 *
 */
@Component
public class PhoneNumberValidator {
    private PhoneNumberValidator() {

    }

    public static boolean isValid(String phoneNumber, String countryCode) {
        boolean isValid = true;
        switch (countryCode) {
        case Constants.CAMEROON_COUNTRY_CODE:
            isValid = validatePhoneNumber(phoneNumber, Constants.CAMEROON_REGEX);
            break;
        case Constants.ETHIOPIA_COUNTRY_CODE:
            isValid = validatePhoneNumber(phoneNumber, Constants.ETHIOPIA_REGEX);
            break;
        case Constants.MOROCOO_COUNTRY_CODE:
            isValid = validatePhoneNumber(phoneNumber, Constants.MOROCOO_REGEX);
            break;
        case Constants.MOZAMBIQUE_COUNTRY_CODE:
            isValid = validatePhoneNumber(phoneNumber, Constants.MOZAMBIQUE_REGEX);
            break;
        case Constants.UGANDA_COUNTRY_CODE:
            isValid = validatePhoneNumber(phoneNumber, Constants.UGANDA_REGEX);
            break;
        default:
            break;
        }
        return isValid;

    }

    private static boolean validatePhoneNumber(String phoneNumber, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
