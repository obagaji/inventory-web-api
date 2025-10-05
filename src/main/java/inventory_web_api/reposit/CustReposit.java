package inventory_web_api.reposit;
import inventory_web_api.webInEntity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustReposit extends JpaRepository<Customers, Long> {


}
