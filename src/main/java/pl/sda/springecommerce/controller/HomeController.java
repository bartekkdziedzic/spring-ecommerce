package pl.sda.springecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.springecommerce.ProductOperation;
import pl.sda.springecommerce.service.CartService;

import java.security.Principal;

@Controller
public class HomeController {

    private final CartService cartService;

    public HomeController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", cartService.getAllProducts());
        return "home";
    }


    @GetMapping("/add/{productId}")
    public String addProductToCart(@PathVariable("productId") Long productId, Model model, Principal principal) {
        principal.getName();
        cartService.productOperation(productId, ProductOperation.ADD);
        model.addAttribute("products", cartService.getAllProducts());
        return "home";
    }


}
