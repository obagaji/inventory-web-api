package inventory_web_api.appDto;

import inventory_web_api.webInEntity.Customers;
import inventory_web_api.webInEntity.Items;

import java.util.Set;

public record SalesDto(Long id, double totalSale, double discount,
                       Customers customer, Set<Items> itemsSet) {
}
