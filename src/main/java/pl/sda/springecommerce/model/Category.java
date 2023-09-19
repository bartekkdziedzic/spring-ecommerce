package pl.sda.springecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_categories")
//    private Product product;


}
