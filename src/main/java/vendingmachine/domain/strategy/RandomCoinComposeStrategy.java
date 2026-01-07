package vendingmachine.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.common.error.DomainException;
import vendingmachine.common.error.ErrorMessage;
import vendingmachine.domain.balance.Coin;
import vendingmachine.domain.balance.CoinChunk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomCoinComposeStrategy implements CoinComposeStrategy {

    @Override
    public List<CoinChunk> composeCoinChunks(final int machineAmount) {
        if (machineAmount < 0) {
            throw new DomainException(ErrorMessage.BELOW_MIN_VALUE, 0);
        }

        List<Integer> coinAmounts = Coin.getCoinAmountValues();
        Map<Coin, Integer> coinQuantityMap = calculateCoinQuantityFrom(machineAmount, coinAmounts);
        return coinQuantityMap.entrySet().stream()
                .map(entry -> new CoinChunk(entry.getKey(), entry.getValue()))
                .toList();
    }

    private Map<Coin, Integer> calculateCoinQuantityFrom(final int machineAmount, final List<Integer> coinAmounts) {
        int leftMachineAmount = machineAmount;
        Map<Coin, Integer> coinMap = new HashMap<>();
        initializeCoinMap(coinMap);

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

    private void initializeCoinMap(final Map<Coin, Integer> coinMap) {
        Arrays.stream(Coin.values())
                .forEach(coin -> coinMap.put(coin, 0));
    }
}
