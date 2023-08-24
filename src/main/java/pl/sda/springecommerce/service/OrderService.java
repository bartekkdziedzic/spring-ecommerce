package pl.sda.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springecommerce.Cart;
import pl.sda.springecommerce.repository.order.OrderProductRepo;
import pl.sda.springecommerce.repository.order.OrderRepo;
import pl.sda.springecommerce.dto.OrderDto;
import pl.sda.springecommerce.mapper.OrderMapper;
import pl.sda.springecommerce.model.order.Order;

@Service
public class OrderService {

    private final Cart cart;
    private final OrderRepo orderRepo;
    private final OrderProductRepo orderProductRepo;

    @Autowired
    public OrderService(Cart cart, OrderRepo orderRepo, OrderProductRepo orderProductRepo) {
        this.cart = cart;
        this.orderRepo = orderRepo;
        this.orderProductRepo = orderProductRepo;
    }


    public void saveOrder(OrderDto orderDto){
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepo.save(order);
        orderProductRepo.saveAll(OrderMapper.mapToOrderProductList(cart, order));
        cart.clearCart();
    }

}
