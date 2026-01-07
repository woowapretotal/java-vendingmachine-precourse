package vendingmachine.infra;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductRepository;

import java.util.List;

public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    @Override
    public void save(final List<Product> products) {
        this.products = products;
    }
}
