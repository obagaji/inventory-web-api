package inventory_web_api.appDto;

import inventory_web_api.webInEntity.Items;

import java.util.Set;

public record CartDto(Long id,int totalItem, double totalExpenses, Set<Items> itemsSet)
{
    public CartDto(Long id,int totalItem, double totalExpenses, Set<Items> itemsSet)
    {
        this.id=id;
        this.totalItem=totalItem;
        this.totalExpenses =totalExpenses;
        this.itemsSet = Set.copyOf(itemsSet);
    }
}

/*
* id;
    private int totalItem;
    private double totalExpenses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<Items> itemsSet;
* */