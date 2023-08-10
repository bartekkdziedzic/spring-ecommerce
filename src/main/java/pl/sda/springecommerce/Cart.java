package pl.sda.springecommerce;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.sda.springecommerce.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {

    private List<CartProduct> cartProducts = new ArrayList<>();
    private int counter = 0;
    private BigDecimal cartSum = BigDecimal.ZERO;


    public void addProduct(Product product) {
        boolean notFound = true;

        for (CartProduct cp : cartProducts) {
            if (cp.getProduct().getId().equals(product.getId())) {
                notFound = false;
                cp.increaseCounter();
                calculatePriceAndCounter();
                break;
            }
        }

        if (notFound) {
            cartProducts.add(new CartProduct(product));
            calculatePriceAndCounter();
        }
    }


    public void removeProduct(Product product) {
        for (CartProduct cp : cartProducts) {
            if (cp.getProduct().getId().equals(product.getId())) {
                cp.decreaseCounter();
                if (cp.hasNoProducts()) {
                    cartProducts.remove(cp);
                }
                calculatePriceAndCounter();
                break;
            }
        }
    }


    public void calculatePriceAndCounter() {
        BigDecimal tempPrice = BigDecimal.ZERO;
        int tempCounter = 0;

        for (CartProduct cp : cartProducts) {
            tempCounter += cp.getCounter();
            tempPrice = tempPrice.add(cp.getProductPriceSum());
        }
        this.counter = tempCounter;
        this.cartSum = tempPrice;

    }


}
