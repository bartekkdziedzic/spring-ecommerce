package pl.sda.springecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.springecommerce.model.Product;

import java.math.BigDecimal;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("product", new Product("Piggy Bank",new BigDecimal(7.50),"https://m.media-amazon.com/images/I/51ckv2myWXL.jpg"));
        // new Product("Piggy Bank",new BigDecimal(7.50),"https://m.media-amazon.com/images/I/51ckv2myWXL.jpg");
        return "home";
    }


}
