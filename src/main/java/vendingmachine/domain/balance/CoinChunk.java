package vendingmachine.domain.balance;

public class CoinChunk {
    private final Coin coin;
    private final int quantity;

    public CoinChunk(final Coin coin, final int quantity) {
        this.coin = coin;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "CoinChunk{" +
                "coin=" + coin +
                ", quantity=" + quantity +
                '}';
    }
}
