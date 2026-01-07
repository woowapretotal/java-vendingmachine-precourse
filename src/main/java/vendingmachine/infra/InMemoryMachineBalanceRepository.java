package vendingmachine.infra;

import vendingmachine.domain.balance.MachineBalance;
import vendingmachine.domain.balance.MachineBalanceRepository;

public class InMemoryMachineBalanceRepository implements MachineBalanceRepository {
    private MachineBalance machineBalance;

    @Override
    public void saveMachineBalance(MachineBalance machineBalance) {
        this.machineBalance = machineBalance;
    }
}
