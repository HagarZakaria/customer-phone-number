package com.jpay.customer.phone.number.service;

import java.util.List;

import com.jpay.customer.phone.number.domain.CustomerModel;

public interface CustomerPhoneNumberService {

    List<CustomerModel> findCustomerPhoneNumers(String countryCode, String state);

}
