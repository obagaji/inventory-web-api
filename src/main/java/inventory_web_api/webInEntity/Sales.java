package inventory_web_api.webInEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Sales {

    @Id
    private Long id;
    private double totalSale;
    private double discount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "items_id")
    Items items;
}
