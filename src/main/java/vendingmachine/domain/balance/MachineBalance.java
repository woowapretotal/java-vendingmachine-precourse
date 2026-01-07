package vendingmachine.domain.balance;

import java.util.ArrayList;
import java.util.Comparator;
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

    public void decreaseCustomerAmount(final int decreasedAmount) {
        this.customerInputAmount -= decreasedAmount;
    }

    public boolean canPurchaseProductCompareWith(final int productPrice) {
        return customerInputAmount < productPrice;
    }

    public List<CoinChunk> composeRefundedCoinChunks() {
        List<CoinChunk> sortedCoinChunks = sortCoinChunk();

        List<CoinChunk> coinChunksForRefund = new ArrayList<>();
        for (CoinChunk coinChunk : sortedCoinChunks) {
            addRefundCoinChunk(coinChunk, coinChunksForRefund);
        }

        return coinChunksForRefund;
    }

    private void addRefundCoinChunk(final CoinChunk coinChunk, final List<CoinChunk> coinChunksForRefund) {
        if (!coinChunk.isCoinAmountOverThan(customerInputAmount)) {
            int refundCoinQuantity = coinChunk.calculateMaxRefundsQuantity(customerInputAmount);
            coinChunksForRefund.add(new CoinChunk(coinChunk.getCoin(), refundCoinQuantity));
            customerInputAmount -= refundCoinQuantity * coinChunk.getCoinAmount();
            return;
        }
        coinChunksForRefund.add(new CoinChunk(coinChunk.getCoin(), 0));
    }

    private List<CoinChunk> sortCoinChunk() {
        return coinChunks.stream()
                .sorted(Comparator.comparingInt(CoinChunk::getCoinAmount))
                .toList();
    }
}
