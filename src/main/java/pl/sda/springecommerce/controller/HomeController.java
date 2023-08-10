package pl.sda.springecommerce.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.springecommerce.Cart;
import pl.sda.springecommerce.dao.ProductRepo;
import pl.sda.springecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final ProductRepo productRepo;
    private final Cart cart;

    @Autowired
    public HomeController(ProductRepo productRepo, Cart cart) {
        this.productRepo = productRepo;
        this.cart = cart;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "home";
    }


    @GetMapping("/add/{productId}")
    public String addProductToCart(@PathVariable("productId") Long productId, Model model){

        Optional<Product> oProduct = productRepo.findById(productId);
        if (oProduct.isPresent()) {
            Product product = oProduct.get();
            cart.addProduct(product);
        }
        model.addAttribute("products", productRepo.findAll());
        return "home";
    }

}
