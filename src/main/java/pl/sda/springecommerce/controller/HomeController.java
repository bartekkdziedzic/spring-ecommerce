package pl.sda.springecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.springecommerce.model.Product;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {

private List<Product> products = List.of(
        new Product("Piggy Bank",new BigDecimal(7.50),"https://m.media-amazon.com/images/I/51ckv2myWXL.jpg"),
         new Product("Black cat",new BigDecimal(8.50),"https://www.rd.com/wp-content/uploads/2021/01/GettyImages-1175550351.jpg"),
          new Product("Porky",new BigDecimal(9.50),"https://icdn.2cda.pl/g/122975_147752136690542103.jpg")
);

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("products", products);
        return "home";
    }


}
