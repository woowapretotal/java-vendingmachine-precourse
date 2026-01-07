package vendingmachine.application.service.response;

import vendingmachine.domain.CoinChunk;

import java.util.List;

public record CoinChunksResponse(
        List<CoinChunkResponse> coinChunkResponses
) {
    public static CoinChunksResponse from(final List<CoinChunk> coinChunks) {
        return new CoinChunksResponse(coinChunks.stream()
                .map(CoinChunkResponse::from)
                .toList()
        );
    }
}
