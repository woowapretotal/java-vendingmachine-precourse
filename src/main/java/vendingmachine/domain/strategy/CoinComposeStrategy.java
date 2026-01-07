package vendingmachine.domain.strategy;

import vendingmachine.domain.CoinChunk;

import java.util.List;

public interface CoinComposeStrategy {
    
    List<CoinChunk> composeCoinChunks(int machineAmount);
}
