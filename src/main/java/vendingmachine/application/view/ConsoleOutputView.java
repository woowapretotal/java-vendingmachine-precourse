package vendingmachine.application.view;

import vendingmachine.application.service.response.CoinChunksResponse;
import vendingmachine.common.constant.GlobalMessage;

public class ConsoleOutputView {

    public void printOnboardingMessage(final String message) {
        System.out.println(message);
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(OutputFormatter.formatErrorMessage(errorMessage));
    }

    public void printVendingMachineCoinQuantity(final CoinChunksResponse coinChunks) {
        System.out.println("자판기가 보유한 동전");
        System.out.print(OutputFormatter.formatCoinChunks(coinChunks) + GlobalMessage.BLANK_AND_NEW_LINE);
    }

}
