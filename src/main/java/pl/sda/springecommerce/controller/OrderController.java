package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.springecommerce.service.CartService;

@Controller
@RequestMapping("/order")
public class OrderController {


    private final CartService cartService;

    @Autowired
    public OrderController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cart";
    }

    @GetMapping("/increase/{productId}")
    public String increaseProduct(@PathVariable("productId") Long productId) {
        cartService.addProductToCart(productId);
        return "cart";
    }

    @GetMapping("/decrease/{productId}")
    public String decreaseProduct(@PathVariable("productId") Long productId) {
        cartService.removeProductFromCart(productId);
        return "cart";
    }


    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        cartService.deleteProductFromCart(productId);
        return "cart";
    }

}
