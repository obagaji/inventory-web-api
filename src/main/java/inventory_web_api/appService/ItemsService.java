package inventory_web_api.appService;


import inventory_web_api.reposit.CartReposit;
import inventory_web_api.reposit.CustReposit;
import inventory_web_api.reposit.ItemsReposit;
import inventory_web_api.webInEntity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ItemsService {
    @Autowired
    ItemsReposit itemsReposit;

    @Autowired
    CartReposit cartReposit;

    @Autowired
    CustReposit custReposit;

    public Items saveItems(Items items)
    {
        return itemsReposit.save(items);
    }

    public List<Items> getAllItems()
    {
        return itemsReposit.findAll();
    }
    public Items getIndividualitem(Long id)
    {
        Items it = new Items();
        Optional<Items> itemOption = itemsReposit.findById(id);
        if( itemOption.isPresent())
        {
            it = itemOption.get();
        }
        return it;
    }
    public int updateIndividualItem(Long id, int quantityPrice, int available)
    {
        return itemsReposit.updateItemInfo(quantityPrice,available,id);
    }
    public void deleteItems(Long id)
    {
      //  Set<Items> itemSet = cartReposit.getAllItemInCart();
      //  Optional<Items> its = itemsReposit.findById(id);
        itemsReposit.deleteById(id);

    }

}
