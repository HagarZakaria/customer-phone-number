package com.jpay.customer.phone.number.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PhoneNumberValidatorTest {

    public static Stream<Arguments> prepareData() {

        return Stream.of(Arguments.of("(212) 6007989253", "212", false), Arguments.of("(212) 698054317", "212", true),
                Arguments.of("(258) 847651504", "258", true), Arguments.of("(258) 84330678235", "258", false),
                Arguments.of("(256) 7503O6263", "256", false), Arguments.of("(256) 704244430", "256", true),
                Arguments.of("(251) 9773199405", "251", false), Arguments.of("(251) 914148181", "251", true),
                Arguments.of("(237) 697151594", "237", true), Arguments.of("(237) 6780009592", "237", false));
    }

    @ParameterizedTest
    @MethodSource("prepareData")
    void testPhoneNumberValidator(String phone, String countryCode, boolean expectedResult) {
        assertEquals(expectedResult, PhoneNumberValidator.isValid(phone, countryCode));
    }

}
