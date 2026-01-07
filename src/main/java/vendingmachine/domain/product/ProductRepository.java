package vendingmachine.domain.product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(List<Product> products);

    Optional<Product> findByProductName(String productName);

    List<Product> findAll();
}
