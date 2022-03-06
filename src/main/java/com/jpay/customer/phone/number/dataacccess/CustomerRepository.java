package com.jpay.customer.phone.number.dataacccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpay.customer.phone.number.domain.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    @Query("select c from CustomerModel c where ((:countryCode is null) or (c.phone like CONCAT('%(',:countryCode,')%')))")
    List<CustomerModel> findByCountryCode(@Param("countryCode") String countryCode);

}
