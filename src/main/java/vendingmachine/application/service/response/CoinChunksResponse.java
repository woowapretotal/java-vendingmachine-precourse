package vendingmachine.application.service.response;

import java.util.List;

public record CoinChunksResponse(
        List<CoinChunkResponse> coinChunkResponses
) {
}
