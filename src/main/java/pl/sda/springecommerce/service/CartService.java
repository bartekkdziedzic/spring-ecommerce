package pl.sda.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springecommerce.Cart;
import pl.sda.springecommerce.dao.ProductRepo;
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




    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }


    public void addProductToCart(Long productId){
        Optional<Product> oProduct = productRepo.findById(productId);
        if (oProduct.isPresent()) {
            Product product = oProduct.get();
            cart.addProduct(product);
        }
    }


    public void removeProductFromCart(Long productId){
        Optional<Product> oProduct = productRepo.findById(productId);
        if (oProduct.isPresent()) {
            Product product = oProduct.get();
            cart.removeProduct(product);
        }
    }


    public void deleteProductFromCart(Long productId){
        Optional<Product> oProduct = productRepo.findById(productId);
        if (oProduct.isPresent()) {
            Product product = oProduct.get();
            cart.deleteProduct(product);
        }
    }


}
