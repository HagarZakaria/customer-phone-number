package com.jpay.customer.phone.number.restapi;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpay.customer.phone.number.domain.CustomerModel;
import com.jpay.customer.phone.number.server.api.CustomerPhoneNumberApi;
import com.jpay.customer.phone.number.server.dto.CustomerPhoneNumberApiDto;
import com.jpay.customer.phone.number.service.CustomerPhoneNumberService;

@Features(features = { "org.apache.cxf.jaxrs.validation.JAXRSBeanValidationFeature",
        "org.apache.cxf.ext.logging.LoggingFeature" })
@Component
public class CustomerPhoneNumberRestImpl implements CustomerPhoneNumberApi {

    @Autowired
    private CustomerPhoneNumberMapper mapper;

    @Autowired
    private CustomerPhoneNumberService customerPhoneNumberService;

    @Override
    public List<CustomerPhoneNumberApiDto> findCustomerPhoneNumbers(String xCMPTenantId, String xCorrelationId,
            String countryCode, String state) {
        List<CustomerModel> customersCustomerModels = customerPhoneNumberService.findCustomerPhoneNumers(countryCode,
                state);
        return customersCustomerModels.stream().map(mapper::mapModelToDto).collect(Collectors.toList());

    }

}
