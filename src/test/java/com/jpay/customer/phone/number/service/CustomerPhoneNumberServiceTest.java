package com.jpay.customer.phone.number.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jpay.customer.phone.number.dataacccess.CustomerRepository;
import com.jpay.customer.phone.number.domain.CustomerModel;

@ExtendWith(SpringExtension.class)
class CustomerPhoneNumberServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerPhoneNumberServiceImpl customerPhoneNumberService;

    @ParameterizedTest
    @MethodSource("prepareData")
    void testFindCustomerPhoneNumers(String countryCode, String state, int expectedResult) {
        List<CustomerModel> customerList = prepareCustomerList();
        when(customerRepository.findByCountryCode(any(String.class))).thenReturn(customerList);
        List<CustomerModel> response = customerPhoneNumberService.findCustomerPhoneNumers(countryCode, state);
        assertNotNull(response);
        assertEquals(expectedResult, response.size());
    }

    public static Stream<Arguments> prepareData() {

        return Stream.of(Arguments.of("237", "VALID", 1), Arguments.of("237", "NOTVALID", 2),
                Arguments.of("237", null, 3));
    }

    private List<CustomerModel> prepareCustomerList() {
        List<CustomerModel> customerList = new ArrayList<>();
        CustomerModel customer1 = new CustomerModel();
        customer1.setName("hagar");
        customer1.setPhone("(237) 677046616");
        CustomerModel customer2 = new CustomerModel();
        customer2.setName("Ali");
        customer2.setPhone("(237) 6780009592");
        CustomerModel customer3 = new CustomerModel();
        customer3.setName("AHmed");
        customer3.setPhone("(237) 6622284920");
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        return customerList;
    }

}
