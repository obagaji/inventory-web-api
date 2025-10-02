package inventory_web_api.appService;


import inventory_web_api.exceptPackage.EmptySalesException;
import inventory_web_api.reposit.SalesReposit;
import inventory_web_api.webInEntity.Sales;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class SalesService {

    @Autowired
    SalesReposit salesReposit;

    public Sales getSales(long salesId)
    {
        Optional<Long>idCheck = Optional.of(salesId);
        if (idCheck.isPresent()) {
            return salesReposit.findById(salesId).orElseGet(new EmptySalesException());
        }
        else {
            throw new IllegalArgumentException("No Value Passed In");
        }
    }
    public List<Sales>getAllSales()
    {
        return salesReposit.findAll();
    }

}
