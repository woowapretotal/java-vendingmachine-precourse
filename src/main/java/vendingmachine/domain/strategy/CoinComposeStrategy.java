package vendingmachine.domain.strategy;

import vendingmachine.domain.balance.CoinChunk;

import java.util.List;

public interface CoinComposeStrategy {

    List<CoinChunk> composeCoinChunks(int machineAmount);
}
