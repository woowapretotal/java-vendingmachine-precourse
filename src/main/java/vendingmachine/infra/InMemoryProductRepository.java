package vendingmachine.infra;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products;

    @Override
    public void save(final List<Product> products) {
        this.products = products;
    }

    @Override
    public Optional<Product> findByProductName(final String productName) {
        return products.stream()
                .filter(product -> product.isSameName(productName))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
