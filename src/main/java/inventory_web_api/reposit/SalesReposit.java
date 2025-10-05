package inventory_web_api.reposit;

import inventory_web_api.webInEntity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalesReposit extends JpaRepository<Sales,Long> {

    @Modifying
    @Query("Update Sales SET discount = discount , totalSale=totalSale where id=id")
    int updateSales(@Param("discount") double discount, @Param("totalSale")
    double totalSales, @Param("id")Long id);

}
