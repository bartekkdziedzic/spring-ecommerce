package pl.sda.springecommerce;


import lombok.Getter;
import pl.sda.springecommerce.model.Product;

import java.math.BigDecimal;

@Getter
public class CartProduct {
    private Product product;
    private int counter;
    private BigDecimal productPriceSum;


    public CartProduct(Product product) {
        this.product = product;
        this.counter = 1;
        this.productPriceSum = product.getPrice();
    }

    public void increaseCounter() {
        counter++;
        recalculate();
    }

    public void decreaseCounter() {
        if (counter > 0) {
            counter--;
            recalculate();
        }
    }

    public void recalculate() {
        productPriceSum = product.getPrice().multiply(new BigDecimal(counter));
    }


    public boolean hasNoProducts() {
        return counter == 0;
    }


    public boolean idEquals(Product product){
        return this.product.getId().equals(product.getId());
    }

}
