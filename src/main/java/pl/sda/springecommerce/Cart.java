package pl.sda.springecommerce;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.sda.springecommerce.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {

    private List<CartProduct> cartProducts = new ArrayList<>();
    private int counter = 0;
    private BigDecimal cartSum = BigDecimal.ZERO;


    public void addProduct(Product product) {
        getCartProduct(product).ifPresentOrElse(
                CartProduct::increaseCounter,
                () -> cartProducts.add(new CartProduct(product))
        );
        calculatePriceAndCounter();
    }


    public void decreaseProduct(Product product) {
        Optional<CartProduct> optionalCartProduct = getCartProduct(product);
        if (optionalCartProduct.isPresent()) {
            CartProduct cartProduct = optionalCartProduct.get();
            cartProduct.decreaseCounter();
            if (cartProduct.hasNoProducts()) {
                deleteProduct(product);
            }
        }
        calculatePriceAndCounter();
    }


    public void deleteProduct(Product product) {
        cartProducts.removeIf(p -> p.idEquals(product));
        calculatePriceAndCounter();
    }


    public void calculatePriceAndCounter() {

        cartSum = cartProducts.stream().map(CartProduct::getProductPriceSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        counter = cartProducts.stream().mapToInt(CartProduct::getCounter)
                .reduce(0, Integer::sum);


    }

    private Optional<CartProduct> getCartProduct(Product product) {
        return cartProducts.stream()
                .filter(cp -> cp.idEquals(product))
                .findFirst();
    }


    public void clearCart() {
        cartProducts.clear();
        counter = 0;
        cartSum = BigDecimal.ZERO;
    }

}
