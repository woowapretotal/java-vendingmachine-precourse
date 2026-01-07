package vendingmachine.infra;

import vendingmachine.domain.MachineBalance;
import vendingmachine.domain.MachineBalanceRepository;

public class InMemoryMachineBalanceRepository implements MachineBalanceRepository {
    private MachineBalance machineBalance;

    @Override
    public void saveMachineBalance(MachineBalance machineBalance) {
        this.machineBalance = machineBalance;
    }
}
