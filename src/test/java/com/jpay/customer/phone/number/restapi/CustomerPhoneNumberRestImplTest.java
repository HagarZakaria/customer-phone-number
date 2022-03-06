package com.jpay.customer.phone.number.restapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jpay.customer.phone.number.domain.CustomerModel;
import com.jpay.customer.phone.number.server.dto.CustomerPhoneNumberApiDto;
import com.jpay.customer.phone.number.service.CustomerPhoneNumberService;

@ExtendWith(SpringExtension.class)
class CustomerPhoneNumberRestImplTest {

    @Mock
    private CustomerPhoneNumberMapper mapper;

    @Mock
    private CustomerPhoneNumberService customerPhoneNumberService;

    @InjectMocks
    private CustomerPhoneNumberRestImpl customerPhoneNumberRestImpl;

    @Test
    void testFindCustomerPhoneNumbers() {
        List<CustomerModel> customerModels = new ArrayList<>();
        customerModels.add(new CustomerModel());
        when(customerPhoneNumberService.findCustomerPhoneNumers(any(String.class), any(String.class)))
                .thenReturn(customerModels);
        when(mapper.mapModelToDto(any())).thenReturn(new CustomerPhoneNumberApiDto());
        List<CustomerPhoneNumberApiDto> response = customerPhoneNumberRestImpl.findCustomerPhoneNumbers("", "", "", "");
        assertEquals(1, response.size());

    }

}
