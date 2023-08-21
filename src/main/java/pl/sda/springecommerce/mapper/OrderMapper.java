package pl.sda.springecommerce.mapper;

import pl.sda.springecommerce.Cart;
import pl.sda.springecommerce.CartProduct;
import pl.sda.springecommerce.dto.OrderDto;
import pl.sda.springecommerce.model.order.Order;
import pl.sda.springecommerce.model.order.OrderProduct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {


    public static Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postcode(orderDto.getPostcode())
                .city(orderDto.getCity())
                .orderCreationTime(LocalDateTime.now())
                .build();
    }



    public static List<OrderProduct> mapToOrderProductList(Cart cart, Order order){
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (CartProduct cp: cart.getCartProducts()){
            orderProducts.add(new OrderProduct(order.getOrderId(), cp.getProduct().getId(), cp.getCounter()));
        }
        return orderProducts;
    }

}
