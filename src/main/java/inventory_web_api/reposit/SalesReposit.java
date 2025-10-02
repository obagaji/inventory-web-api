package inventory_web_api.reposit;

import inventory_web_api.webInEntity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesReposit extends JpaRepository<Sales,Long> {
}
