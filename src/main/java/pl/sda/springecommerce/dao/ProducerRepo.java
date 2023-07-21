package pl.sda.springecommerce.dao;


import org.springframework.data.repository.CrudRepository;
import pl.sda.springecommerce.model.Producer;

public interface ProducerRepo extends CrudRepository <Producer, Integer>{
}
