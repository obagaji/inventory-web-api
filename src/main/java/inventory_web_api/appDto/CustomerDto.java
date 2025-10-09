package inventory_web_api.appDto;

import inventory_web_api.webInEntity.Address;


import java.util.Set;

public record CustomerDto(Long id,String customerName, String customerPhone,
                          Address address) {
}
