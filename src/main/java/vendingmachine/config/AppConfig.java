package vendingmachine.config;

import vendingmachine.application.controller.VendingMachineController;
import vendingmachine.application.controller.adapter.ConsoleInputAdapter;
import vendingmachine.application.service.VendingMachineService;
import vendingmachine.application.view.ConsoleInputView;
import vendingmachine.application.view.ConsoleOutputView;
import vendingmachine.domain.MachineBalanceRepository;
import vendingmachine.domain.service.VendingMachine;
import vendingmachine.domain.strategy.CoinComposeStrategy;
import vendingmachine.domain.strategy.RandomCoinComposeStrategy;
import vendingmachine.infra.InMemoryMachineBalanceRepository;

public class AppConfig {
    // == repository ==
    private final MachineBalanceRepository machineBalanceRepository = new InMemoryMachineBalanceRepository();

    // == view ==
    private final ConsoleInputView inputView = new ConsoleInputView();
    private final ConsoleOutputView outputView = new ConsoleOutputView();
    private final ConsoleInputAdapter inputAdapter = new ConsoleInputAdapter(inputView, outputView);

    // == domain service ==
    private final CoinComposeStrategy coinComposeStrategy = new RandomCoinComposeStrategy();
    private final VendingMachine vendingMachine = new VendingMachine();

    // == application service ==
    private final VendingMachineService vendingMachineService = new VendingMachineService(coinComposeStrategy, vendingMachine, machineBalanceRepository);

    // == controller ==
    private final VendingMachineController vendingMachineController = new VendingMachineController(vendingMachineService, inputAdapter, outputView);

    public VendingMachineController vendingMachineController() {
        return vendingMachineController;
    }

}
