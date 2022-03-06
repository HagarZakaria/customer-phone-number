package com.jpay.customer.phone.number.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpay.customer.phone.number.common.Constants;
import com.jpay.customer.phone.number.dataacccess.CustomerRepository;
import com.jpay.customer.phone.number.domain.CustomerModel;
import com.jpay.customer.phone.number.validator.PhoneNumberValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerPhoneNumberServiceImpl implements CustomerPhoneNumberService {

    @Autowired
    private CustomerRepository customerRepository;


    /**
     * retrieve list of customer phone numbers filtered by country & phone numer
     * state
     */
    @Override
    public List<CustomerModel> findCustomerPhoneNumers(String countryCode, String state) {
        List<CustomerModel> customers = customerRepository.findByCountryCode(countryCode);
        if (state != null && !state.isEmpty() && Constants.VALID.equals(state)) {
            log.info("Retrieve valid phone numbers for country with code {}", countryCode);
            return customers.stream().filter(c -> PhoneNumberValidator.isValid(c.getPhone(), countryCode))
                    .collect(Collectors.toList());

        }
        else if (state != null && !state.isEmpty() && Constants.NOT_VALID.equals(state)) {
            log.info("Retrieve invalid phone numbers for country with code {}", countryCode);
            return customers.stream().filter(c -> !PhoneNumberValidator.isValid(c.getPhone(), countryCode))
                    .collect(Collectors.toList());
        }
        return customers;
    }


}
