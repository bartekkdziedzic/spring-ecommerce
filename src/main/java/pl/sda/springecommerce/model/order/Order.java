package pl.sda.springecommerce.model.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String firstName;
    private String lastName;
    private String address;
    private String postcode;
    private String city;
    private LocalDateTime orderCreationTime;


    @OneToMany
    @JoinColumn(name = "orderId")
    private List<OrderProduct> orderProducts;
}
