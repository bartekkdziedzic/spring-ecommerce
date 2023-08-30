package pl.sda.springecommerce.service;

import org.springframework.stereotype.Service;
import org.h2.fulltext.FullText;
import pl.sda.springecommerce.model.Product;
import pl.sda.springecommerce.repository.ProductRepo;

import java.util.List;

@Service
public class SearchService {

private ProductRepo productRepo;

    public SearchService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    public List<Product> searchProducts(String query){
        return productRepo.findByNameContainingIgnoreCase(query);
    }


}
