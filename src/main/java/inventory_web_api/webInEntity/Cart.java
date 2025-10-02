package inventory_web_api.webInEntity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalItem;
    private double totalExpenses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart",orphanRemoval = true)
    private Set<Items> itemsSet;

}
