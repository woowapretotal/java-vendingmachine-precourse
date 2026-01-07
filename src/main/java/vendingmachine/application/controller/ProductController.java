package vendingmachine.application.controller;

import vendingmachine.application.controller.adapter.ConsoleInputAdapter;
import vendingmachine.application.service.ProductService;
import vendingmachine.application.service.request.ProductRegisterRequest;
import vendingmachine.application.view.ConsoleOutputView;

import java.util.List;

public class ProductController extends RetryController {
    private final ProductService productService;
    private final ConsoleInputAdapter inputAdapter;

    public ProductController(final ProductService productService, final ConsoleInputAdapter inputAdapter, final ConsoleOutputView outputView) {
        super(outputView);
        this.productService = productService;
        this.inputAdapter = inputAdapter;
    }

    public void registerProductsWithRetrying() {
        List<ProductRegisterRequest> productRegisterRequests =
                inputAdapter.readRegisteredProductsRequest();
        productService.registerProducts(productRegisterRequests);
    }
}
