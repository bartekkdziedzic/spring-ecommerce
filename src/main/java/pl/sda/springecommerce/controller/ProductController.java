package pl.sda.springecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springecommerce.model.Product;
import pl.sda.springecommerce.service.SearchService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String searchItems(@RequestParam String query, Model model) {
        List<Product> searchResult = searchService.searchProducts(query);
        model.addAttribute("searchResult", searchResult);

        return "results";
    }

    @GetMapping("/search-form")
    public String showSearchForm() {
        return "/";
    }


}
