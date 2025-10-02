package inventory_web_api.reposit;

import inventory_web_api.webInEntity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsReposit extends JpaRepository<Items,Long> {
}
