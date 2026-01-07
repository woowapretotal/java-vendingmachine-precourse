package vendingmachine.application.service;

import vendingmachine.application.service.response.CoinChunksResponse;
import vendingmachine.domain.balance.MachineBalance;
import vendingmachine.domain.balance.MachineBalanceRepository;
import vendingmachine.domain.service.VendingMachine;
import vendingmachine.domain.strategy.CoinComposeStrategy;

public class VendingMachineService {
    private final CoinComposeStrategy coinComposeStrategy;
    private final VendingMachine vendingMachine;
    private final MachineBalanceRepository machineBalanceRepository;

    public VendingMachineService(final CoinComposeStrategy coinComposeStrategy, final VendingMachine vendingMachine, final MachineBalanceRepository machineBalanceRepository) {
        this.coinComposeStrategy = coinComposeStrategy;
        this.vendingMachine = vendingMachine;
        this.machineBalanceRepository = machineBalanceRepository;
    }

    public CoinChunksResponse composeCoinQuantityFrom(final int machineAmount) {
        MachineBalance machineBalance = vendingMachine.initializeVendingMachine(machineAmount, coinComposeStrategy);
        machineBalanceRepository.saveMachineBalance(machineBalance);
        return CoinChunksResponse.from(machineBalance.getCoinChunks());
    }
}
