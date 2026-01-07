package vendingmachine.application.service.response;

import vendingmachine.domain.balance.CoinChunk;

public record CoinChunkResponse(
        int amount,
        int quantity
) {

    public static CoinChunkResponse from(CoinChunk coinChunk) {
        return new CoinChunkResponse(coinChunk.getCoinAmount(), coinChunk.getQuantity());
    }
}
