package com.jpay.customer.phone.number.restapi;

import org.mapstruct.Mapper;

import com.jpay.customer.phone.number.domain.CustomerModel;
import com.jpay.customer.phone.number.server.dto.CustomerPhoneNumberApiDto;

@Mapper(componentModel = "spring")
public interface CustomerPhoneNumberMapper {

    CustomerPhoneNumberApiDto mapModelToDto(CustomerModel model);


}
