package pl.sda.springecommerce.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.springecommerce.model.order.OrderProduct;

@Repository
public interface OrderProductRepo extends JpaRepository<OrderProduct,Long> {
}
