package vendingmachine.application.service.response;

public record CoinChunkResponse(
        int amount,
        int quantity
) {
}
