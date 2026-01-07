package vendingmachine.application.service;

import vendingmachine.application.service.request.ProductRegisterRequest;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void registerProducts(final List<ProductRegisterRequest> productRegisterRequests) {
        List<Product> products = productRegisterRequests.stream()
                .map(request -> new Product(request.productNane(), request.price(), request.stockQuantity()))
                .toList();

        productRepository.save(products);
    }
}
