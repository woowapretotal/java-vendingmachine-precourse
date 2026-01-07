package vendingmachine.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.balance.Coin;
import vendingmachine.domain.balance.CoinChunk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomCoinComposeStrategy implements CoinComposeStrategy {

    @Override
    public List<CoinChunk> composeCoinChunks(final int machineAmount) {
        List<Integer> coinAmounts = Coin.getCoinAmountValues();
        Map<Coin, Integer> coinQuantityMap = calculateCoinQuantityFrom(machineAmount, coinAmounts);
        return coinQuantityMap.entrySet().stream()
                .map(entry -> new CoinChunk(entry.getKey(), entry.getValue()))
                .toList();
    }

    private Map<Coin, Integer> calculateCoinQuantityFrom(final int machineAmount, final List<Integer> coinAmounts) {
        int leftMachineAmount = machineAmount;
        Map<Coin, Integer> coinMap = new HashMap<>();

        while (leftMachineAmount > 0) {
            int coinAmount = Randoms.pickNumberInList(coinAmounts);
            if (coinAmount <= leftMachineAmount) {
                Coin coin = Coin.findCoinFromAmount(coinAmount);
                coinMap.merge(coin, 1, Integer::sum);
                leftMachineAmount -= coinAmount;
            }
        }
        return coinMap;
    }
}
