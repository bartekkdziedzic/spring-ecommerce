package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.springecommerce.ProductOperation;
import pl.sda.springecommerce.dto.OrderDto;
import pl.sda.springecommerce.service.CartService;
import pl.sda.springecommerce.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {


    private final CartService cartService;
    private final OrderService orderService;

    @Autowired
    public OrderController(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cart";
    }

    @GetMapping("/increase/{productId}")
    public String increaseProduct(@PathVariable("productId") Long productId) {
        cartService.productOperation(productId, ProductOperation.ADD);
        return "cart";
    }

    @GetMapping("/decrease/{productId}")
    public String decreaseProduct(@PathVariable("productId") Long productId) {
        cartService.productOperation(productId, ProductOperation.DECREASE);
        return "cart";
    }


    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        cartService.productOperation(productId, ProductOperation.DELETE);
        return "cart";
    }

@GetMapping("/orderSummary")
public String showOrderSummary(){
        return "orderSummary";
}

@PostMapping("/saveOrder")
public String saveOrder(OrderDto orderDto){
        orderService.saveOrder(orderDto);
        return "redirect:/";
}





}
