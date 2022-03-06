package com.jpay.customer.phone.number.dataacccess;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.jpay.customer.phone.number.domain.CustomerModel;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("h2-test")
@DataJpaTest
@Sql(scripts = "/insert-into-db.sql")
@Sql(scripts = "/delete-from-db.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindByCountryCode() {

        List<CustomerModel> customers = customerRepository.findByCountryCode("237");
        assertEquals(2, customers.size());

    }

}
