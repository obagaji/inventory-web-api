package inventory_web_api.webInEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Sales {

    @Id
    private Long id;
    private double totalSale;
    private double discount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToMany(mappedBy = "salesSet")
    Set<Items> itemsSet;
}
