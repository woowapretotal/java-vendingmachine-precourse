package vendingmachine.domain.balance;

public class CoinChunk {
    private final Coin coin;
    private final int quantity;

    public CoinChunk(final Coin coin, final int quantity) {
        this.coin = coin;
        this.quantity = quantity;
    }

    public boolean isCoinAmountOverThan(int other) {
        return getCoinAmount() > other;
    }

    public int getCoinAmount() {
        return coin.getAmount();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCoinChunkAmount() {
        return coin.getAmount() * quantity;
    }

    public Coin getCoin() {
        return coin;
    }

    public int calculateMaxRefundsQuantity(final int customerInputAmount) {
        int refundsQuantityWhenQuantityEnough = customerInputAmount / getCoinAmount();
        return Math.min(refundsQuantityWhenQuantityEnough, quantity);
    }

    @Override
    public String toString() {
        return "CoinChunk{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                '}';
    }
}
