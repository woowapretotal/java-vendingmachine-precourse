package vendingmachine.domain.product;

import java.util.List;

public interface ProductRepository {

    void save(List<Product> products);
}
