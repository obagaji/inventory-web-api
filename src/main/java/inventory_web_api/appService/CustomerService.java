package inventory_web_api.appService;

import inventory_web_api.reposit.CustReposit;
import inventory_web_api.webInEntity.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustReposit custReposit;

    public Customers saveCustomer(Customers cust)
    {
        return custReposit.save(cust);
    }

    public List<Customers> getAllCustomer() {
        return custReposit.findAll();
    }
    public Customers findOneCustomer(Long id)
    {
        Customers customers = new Customers();
        Optional<Customers> custOpt = custReposit.findById(id);
        if (custOpt.isPresent())
        {
            customers = custOpt.get();
        }
      return customers;
    }

}
