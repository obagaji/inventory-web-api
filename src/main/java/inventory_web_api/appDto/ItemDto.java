package inventory_web_api.appDto;

import inventory_web_api.webInEntity.Cart;
import inventory_web_api.webInEntity.Sales;

import java.util.Set;

public record ItemDto(long id, String itemName, double itemPrice, int itemAvailableQuantity) {
}
