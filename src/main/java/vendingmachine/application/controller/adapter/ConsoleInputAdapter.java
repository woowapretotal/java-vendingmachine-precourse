package vendingmachine.application.controller.adapter;

import vendingmachine.application.view.ConsoleInputView;
import vendingmachine.application.view.ConsoleOutputView;

public class ConsoleInputAdapter {
    private final ConsoleOutputView outputView;
    private final ConsoleInputView inputView;

    public ConsoleInputAdapter(final ConsoleInputView inputView, final ConsoleOutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public int readVendingMachineAmount() {
        outputView.printOnboardingMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return inputView.readNumber();
    }
}
