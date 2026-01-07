package vendingmachine.domain.balance;

import java.util.Optional;

public interface MachineBalanceRepository {

    void saveMachineBalance(MachineBalance machineBalance);

    Optional<MachineBalance> findMachineBalance();
}
