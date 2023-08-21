package pl.sda.springecommerce.dao.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springecommerce.model.order.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
