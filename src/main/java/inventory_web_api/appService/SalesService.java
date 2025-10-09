package inventory_web_api.appService;


import inventory_web_api.exceptPackage.EmptySalesException;
import inventory_web_api.reposit.CustReposit;
import inventory_web_api.reposit.ItemsReposit;
import inventory_web_api.reposit.SalesReposit;
import inventory_web_api.webInEntity.Customers;
import inventory_web_api.webInEntity.Items;
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
    @Autowired
    CustReposit custReposit;
    @Autowired
    ItemsReposit itemsReposit;

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
    public Sales addEachSale(Sales sales)
    {
       return salesReposit.save(sales);
    }
    public int updateSales(double numbers, double addvalue, Long id)
    {
        int x =-1;
        salesReposit.updateSales(numbers,addvalue,id);
        if ( numbers >=1 && addvalue >=1)
        {
           x= salesReposit.updateSales(numbers,addvalue,id);

        }
        return x;
    }

    public Sales updateSales(Sales sale) {
        int x = -1;
        Customers cust = new Customers();
        Items its = new Items();

        Optional<Customers> customers = custReposit.findById(sale.getCustomer().getId());

        Optional<Items> items = itemsReposit.findById(sale.getItems().getId());
        if (!customers.isEmpty()) {
            cust = customers.get();
            custReposit.save(cust);
        }
        if (!items.isEmpty()) {
            its = items.get();
            itemsReposit.save(its);
        }
        Sales sales = Sales.builder()
                .totalSale(sale.getTotalSale())
                .id(sale.getId())
                .discount(sale.getDiscount())
                .customer(cust)
                .items(its)
                .build();
        return salesReposit.save(sales);
    }
    public void deleteSalesReport(Long id)
    {
        Sales sale = new Sales();
        Optional<Sales> optionalSale = salesReposit.findById(id);
        if (optionalSale.isPresent())
        {
            sale = optionalSale.get();
            Optional<Customers> cust = custReposit.findById(sale.getCustomer().getId());
            cust.ifPresent(customers -> custReposit.delete(customers));
            Optional<Items>items = itemsReposit.findById(sale.getItems().getId());
            items.ifPresent(value -> itemsReposit.delete(value));
            salesReposit.delete(optionalSale.get());
        }
    }

}
