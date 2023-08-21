package pl.sda.springecommerce.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class OrderProduct {

    @Id
    @GeneratedValue
    private Long orderProductId;
    private Long orderId;
    private Long productId;
    private int amount;

    public OrderProduct(Long orderId, Long productId, int amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }
}
