package inventory_web_api.SalesServiceTest;

import inventory_web_api.appDto.ItemDto;
import inventory_web_api.appService.SalesService;
import inventory_web_api.reposit.CustReposit;
import inventory_web_api.reposit.ItemsReposit;
import inventory_web_api.reposit.SalesReposit;
import inventory_web_api.webInEntity.Sales;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SalesTest {

    @Autowired
    SalesService salesService;

    @Autowired
    ItemsReposit itemsReposit;
    @Autowired
    CustReposit custReposit;
    @Autowired
    SalesReposit salesReposit;

    @Test
    void testAddingSales()
    {
        Sales sales = Sales.builder()
                .id(11L)
                .discount(3.0)
                .totalSale(100.0)
                .items(itemsReposit.findById(1L).get())
                .customer(custReposit.findById(3L).get())
                .build();
        salesService.addEachSale(sales);

    }

}
