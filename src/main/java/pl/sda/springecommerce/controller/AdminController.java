package pl.sda.springecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.springecommerce.model.Category;
import pl.sda.springecommerce.model.Product;
import pl.sda.springecommerce.model.order.Order;
import pl.sda.springecommerce.repository.CategoryRepo;
import pl.sda.springecommerce.repository.ProductRepo;
import pl.sda.springecommerce.repository.order.OrderRepo;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    private final CategoryRepo categoryRepo;

    public AdminController(ProductRepo productRepo, OrderRepo orderRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    private String adminPage(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "/adminView/adminPage";
    }

    @PostMapping("item")
    private String addItem(Product product) {
        productRepo.save(product);
        return "redirect:/";
    }

    @PostMapping("category")
    private String addCategory(Category category) {
        categoryRepo.save(category);
        return "redirect:/admin";
    }

    @GetMapping("/showOrders")
    @ResponseBody
    private List<Order> showOrders() {
        return orderRepo.findAll();
    }


}
