package vendingmachine.application.controller;

import vendingmachine.application.controller.adapter.ConsoleInputAdapter;
import vendingmachine.application.service.VendingMachineService;
import vendingmachine.application.service.response.CoinChunksResponse;
import vendingmachine.application.view.ConsoleOutputView;

public class VendingMachineController extends RetryController {
    private final VendingMachineService vendingMachineService;
    private final ConsoleInputAdapter inputAdapter;

    public VendingMachineController(final VendingMachineService vendingMachineService, final ConsoleInputAdapter inputAdapter, final ConsoleOutputView outputView) {
        super(outputView);
        this.vendingMachineService = vendingMachineService;
        this.inputAdapter = inputAdapter;
    }

    public void registerMachineAmountWithRetrying() {
        CoinChunksResponse coinChunksResponse = retrying(() -> {
            int machineAmount = inputAdapter.readVendingMachineAmount();
            return vendingMachineService.composeCoinQuantityFrom(machineAmount);
        });

        outputView.printVendingMachineCoinQuantity(coinChunksResponse);
    }
}
