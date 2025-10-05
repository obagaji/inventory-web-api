package inventory_web_api.CartServiceTest;

import inventory_web_api.reposit.CartReposit;
import inventory_web_api.reposit.ItemsReposit;
import inventory_web_api.webInEntity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class CartTest {

    @Autowired
    CartReposit cartReposit;
    @Autowired
    ItemsReposit itemsReposit;


    @Test
    void addToCartTest()
    {
        Items item1 = Items.builder()
            //    .id(100L)
                .itemName("card")
                .itemPrice(100)
                .itemAvailableQuantity(20)
                .build();
      //  itemsReposit.save(item1);
        Customers customers = Customers.builder()
                .customerName("musa")
                .customerPhone("12345")
                .address(new Address("nigeria","benue","1234"))
            //    .id(12L)
                .build();
        Cart carts = Cart.builder()
            //    .id(100L)
                .totalExpenses(19)
                .totalItem(2)
                .itemsSet(Set.of(item1))
                .customers(customers)
                         .build();
        cartReposit.save(carts);

    }


}
