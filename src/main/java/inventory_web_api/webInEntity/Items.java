package inventory_web_api.webInEntity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String itemName;
    private double itemPrice;
    private int itemAvailableQuantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    Cart cart;

    @ManyToMany
    @JoinTable(name = "item_sale", joinColumns = @JoinColumn(name="item_id"),
            inverseJoinColumns = @JoinColumn(name = "sale_id") )
    Set<Sales> salesSet;

}
