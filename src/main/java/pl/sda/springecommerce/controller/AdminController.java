package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.springecommerce.repository.ProductRepo;
import pl.sda.springecommerce.repository.order.OrderRepo;
import pl.sda.springecommerce.model.Product;
import pl.sda.springecommerce.model.order.Order;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    @Autowired
    public AdminController(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
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

    @GetMapping("/showOrders")
    @ResponseBody
    private List<Order> showOrders() {
        return orderRepo.findAll();
    }


}
