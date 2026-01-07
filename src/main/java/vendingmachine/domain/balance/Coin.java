package vendingmachine.domain.balance;

import vendingmachine.common.error.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static List<Integer> getCoinAmountValues() {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .toList();
    }

    public static Coin findCoinFromAmount(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == amount)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.NOT_EXISTS_COIN.message()));
    }
}
