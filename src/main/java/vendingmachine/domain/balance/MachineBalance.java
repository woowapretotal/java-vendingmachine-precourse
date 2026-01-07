package vendingmachine.domain.balance;

import java.util.List;

public class MachineBalance {
    private static final int INITIAL_INPUT_AMOUNT = 0;

    private final List<CoinChunk> coinChunks;
    private int customerInputAmount = INITIAL_INPUT_AMOUNT;

    public MachineBalance(final List<CoinChunk> coinChunks) {
        this.coinChunks = List.copyOf(coinChunks);
    }

    public List<CoinChunk> getCoinChunks() {
        return coinChunks;
    }

    public int getCustomerInputAmount() {
        return customerInputAmount;
    }

    public void insertCustomerAmount(final int customerInsertAmount) {
        this.customerInputAmount += customerInsertAmount;
    }
}
