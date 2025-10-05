package inventory_web_api.itemsServiceTest;


import inventory_web_api.appService.ItemsService;
import inventory_web_api.webInEntity.Items;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestItems {

    @Autowired
    ItemsService itemsService;

    @Test
    void saveItems()
    {
        Items items = Items.builder()
                .itemPrice(200)
           //     .id(20L)
                .itemAvailableQuantity(100)
                .itemName("IPhone")
                .build();
        itemsService.saveItems(items);

    }
}
