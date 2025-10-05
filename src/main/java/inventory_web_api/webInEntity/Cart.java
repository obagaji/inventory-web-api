package inventory_web_api.webInEntity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalItem;
    private double totalExpenses;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "item_id")
    private Set<Items> itemsSet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customers customers;

}
