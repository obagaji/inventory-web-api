package inventory_web_api.reposit;

import inventory_web_api.webInEntity.Cart;
import inventory_web_api.webInEntity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CartReposit extends JpaRepository<Cart,Long>
{
    @Query("Select itemsSet from Cart")
    Set<Items> getAllItemInCart();
}
