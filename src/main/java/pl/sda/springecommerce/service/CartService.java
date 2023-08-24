package pl.sda.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springecommerce.Cart;
import pl.sda.springecommerce.ProductOperation;
import pl.sda.springecommerce.repository.ProductRepo;
import pl.sda.springecommerce.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final ProductRepo productRepo;
    private final Cart cart;

    @Autowired
    public CartService(ProductRepo productRepo, Cart cart) {
        this.productRepo = productRepo;
        this.cart = cart;
    }


    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }


    public void productOperation(Long productId, ProductOperation productOperation) {
        Optional<Product> oProduct = productRepo.findById(productId);
        if (oProduct.isPresent()) {
            Product product = oProduct.get();
            switch (productOperation) {
                case ADD -> cart.addProduct(product);
                case DECREASE -> cart.decreaseProduct(product);
                case DELETE -> cart.deleteProduct(product);
                default -> throw new IllegalArgumentException();
            }
        }


    }
}