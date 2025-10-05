package inventory_web_api.customerServiceTest;

import inventory_web_api.appService.CustomerService;
import inventory_web_api.webInEntity.Address;
import inventory_web_api.webInEntity.Customers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCustomers {

    @Autowired
    CustomerService customerService;

    @Test
    void addCustomer()
    {
        Customers cust = Customers.builder()
             //   .id(100L)
                .address(new Address("nigeria","benue","obagaji"))
                .customerName("musa")
                .customerPhone("123456")
                .build();
        customerService.saveCustomer(cust);

    }
}
