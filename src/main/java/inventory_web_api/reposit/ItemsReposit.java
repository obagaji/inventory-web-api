package inventory_web_api.reposit;

import inventory_web_api.webInEntity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemsReposit extends JpaRepository<Items,Long> {

    @Modifying
    @Query("Update Items Set itemPrice=itemPrice, itemAvailableQuantity = itemAvailableQuantity WHERE id = id")
    int updateItemInfo(@Param("itemPrice") int itemPrice,
                       @Param("itemAvailableQuantity") int itemAvailableQuantity, @Param("id") Long id);

}
