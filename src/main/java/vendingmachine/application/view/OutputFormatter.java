package vendingmachine.application.view;

import vendingmachine.application.service.response.CoinChunkResponse;
import vendingmachine.application.service.response.CoinChunksResponse;
import vendingmachine.common.constant.GlobalMessage;

import java.util.stream.Collectors;


public final class OutputFormatter {

    private OutputFormatter() {
    }

    public static String formatErrorMessage(String message) {
        return GlobalMessage.ERROR_PREFIX + message;
    }

    public static String formatCoinChunks(final CoinChunksResponse coinChunks) {
        return coinChunks.coinChunkResponses().stream()
                .map(OutputFormatter::formatCoinChunk)
                .collect(Collectors.joining(GlobalMessage.LINE_SEPARATOR.get()));
    }

    private static String formatCoinChunk(final CoinChunkResponse coinChunk) {
        return "%d원 - %d개".formatted(coinChunk.amount(), coinChunk.quantity());
    }
}
