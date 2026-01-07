package vendingmachine.domain.service;

import vendingmachine.domain.MachineBalance;
import vendingmachine.domain.strategy.CoinComposeStrategy;

public class VendingMachine {

    public MachineBalance initializeVendingMachine(int machineAmount, CoinComposeStrategy strategy) {
        return new MachineBalance(strategy.composeCoinChunks(machineAmount));
    }
}
