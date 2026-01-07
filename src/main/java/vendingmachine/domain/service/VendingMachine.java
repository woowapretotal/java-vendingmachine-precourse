package vendingmachine.domain.service;

import vendingmachine.common.error.DomainException;
import vendingmachine.common.error.ErrorMessage;
import vendingmachine.common.error.PurchasablePolicyException;
import vendingmachine.domain.balance.MachineBalance;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.strategy.CoinComposeStrategy;

import java.util.List;

public class VendingMachine {

    public MachineBalance initializeVendingMachine(int machineAmount, CoinComposeStrategy strategy) {
        return new MachineBalance(strategy.composeCoinChunks(machineAmount));
    }

    public void validatePurchasable(final List<Product> products, MachineBalance machineBalance) {
        validateBalanceNotBelowMinProductPrice(products, machineBalance);
    }

    private void validateBalanceNotBelowMinProductPrice(final List<Product> products, final MachineBalance machineBalance) {
        int minProductPrice = findMinProductPriceHavingStockQuantity(products);
        if (machineBalance.canPurchaseProductCompareWith(minProductPrice)) {
            throw new PurchasablePolicyException();
        }
    }

    private int findMinProductPriceHavingStockQuantity(final List<Product> products) {
        return products.stream()
                .filter(product -> !product.isStockEmpty())
                .map(Product::getPrice)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.EMPTY_PRODUCT.message()));
    }

    public void purchaseProduct(final Product product, final MachineBalance machineBalance) {
        validateCustomerAmountIsSufficient(product, machineBalance);
        product.purchaseOne();
        machineBalance.decreaseCustomerAmount(product.getPrice());
    }

    private void validateCustomerAmountIsSufficient(final Product product, final MachineBalance machineBalance) {
        if (machineBalance.canPurchaseProductCompareWith(product.getPrice())) {
            throw new DomainException(ErrorMessage.INSUFFICIENT_CUSTOMER_INPUT_AMOUNT);
        }
    }
}
