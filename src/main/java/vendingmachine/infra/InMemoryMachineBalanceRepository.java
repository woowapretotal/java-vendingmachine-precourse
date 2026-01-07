package vendingmachine.infra;

import vendingmachine.domain.balance.MachineBalance;
import vendingmachine.domain.balance.MachineBalanceRepository;

import java.util.Optional;

public class InMemoryMachineBalanceRepository implements MachineBalanceRepository {
    private MachineBalance machineBalance;

    @Override
    public void saveMachineBalance(MachineBalance machineBalance) {
        this.machineBalance = machineBalance;
    }

    @Override
    public Optional<MachineBalance> findMachineBalance() {
        return Optional.ofNullable(machineBalance);
    }
}
