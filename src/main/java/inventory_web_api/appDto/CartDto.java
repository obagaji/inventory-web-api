package inventory_web_api.appDto;

import inventory_web_api.webInEntity.Customers;
import inventory_web_api.webInEntity.Items;

import java.util.Set;

public record CartDto(Long id, int totalItem, double totalExpenses, Set<Items>itemsSet ,Customers customers)
{
    public CartDto(Long id,int totalItem, double totalExpenses, Set<Items>itemsSet,Customers customers)
    {
        this.id=id;
        this.totalItem=totalItem;
        this.totalExpenses =totalExpenses;
        this.itemsSet = Set.copyOf(itemsSet);
        this.customers = customers;
    }
}


