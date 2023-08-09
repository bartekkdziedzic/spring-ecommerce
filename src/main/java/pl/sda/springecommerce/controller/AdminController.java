package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.springecommerce.dao.ProductRepo;
import pl.sda.springecommerce.model.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductRepo productRepo;

    @Autowired
    public AdminController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    private String adminPage() {
        return "adminView/addProduct";
    }

    @PostMapping
    private String addItem(Product product) {
        productRepo.save(product);
        return "redirect:/";
    }

}
