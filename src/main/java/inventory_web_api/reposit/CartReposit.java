package inventory_web_api.reposit;

import inventory_web_api.webInEntity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartReposit extends JpaRepository<Cart,Long> {
}
