package vendingmachine.application.service;

import vendingmachine.application.service.response.CoinChunksResponse;
import vendingmachine.common.error.ApplicationException;
import vendingmachine.common.error.ErrorMessage;
import vendingmachine.domain.balance.CoinChunk;
import vendingmachine.domain.balance.MachineBalance;
import vendingmachine.domain.balance.MachineBalanceRepository;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.ProductRepository;
import vendingmachine.domain.service.VendingMachine;
import vendingmachine.domain.strategy.CoinComposeStrategy;

import java.util.List;

public class VendingMachineService {
    private final CoinComposeStrategy coinComposeStrategy;
    private final VendingMachine vendingMachine;
    private final MachineBalanceRepository machineBalanceRepository;
    private final ProductRepository productRepository;

    public VendingMachineService(final CoinComposeStrategy coinComposeStrategy, final VendingMachine vendingMachine, final MachineBalanceRepository machineBalanceRepository, final ProductRepository productRepository) {
        this.coinComposeStrategy = coinComposeStrategy;
        this.vendingMachine = vendingMachine;
        this.machineBalanceRepository = machineBalanceRepository;
        this.productRepository = productRepository;
    }

    public CoinChunksResponse composeCoinQuantityFrom(final int machineAmount) {
        MachineBalance machineBalance = vendingMachine.initializeVendingMachine(machineAmount, coinComposeStrategy);
        machineBalanceRepository.saveMachineBalance(machineBalance);
        return CoinChunksResponse.from(machineBalance.getCoinChunks());
    }

    public void registerCustomerInputAmount(final int customerInputAmount) {
        MachineBalance machineBalance = findMachineBalance();
        machineBalance.insertCustomerAmount(customerInputAmount);
    }

    public int findCustomerAmount() {
        MachineBalance machineBalance = findMachineBalance();
        return machineBalance.getCustomerInputAmount();
    }

    public void validatePurchasable() {
        vendingMachine.validatePurchasable(productRepository.findAll(), findMachineBalance());
    }

    public void purchaseProductFrom(final String productName) {
        Product product = findProductBy(productName);
        MachineBalance machineBalance = findMachineBalance();
        vendingMachine.purchaseProduct(product, machineBalance);
    }

    public CoinChunksResponse refundCustomerAmount() {
        MachineBalance machineBalance = findMachineBalance();
        List<CoinChunk> coinChunks = machineBalance.composeRefundedCoinChunks();
        return CoinChunksResponse.from(coinChunks);
    }

    private MachineBalance findMachineBalance() {
        return machineBalanceRepository.findMachineBalance()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.EMPTY_MACHINE_BALANCE.message()));
    }

    private Product findProductBy(final String productName) {
        return productRepository.findByProductName(productName)
                .orElseThrow(() -> new ApplicationException(ErrorMessage.NOT_EXISTS_PRODUCT));
    }
}
