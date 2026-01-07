package vendingmachine.application.controller.adapter;

import vendingmachine.application.service.request.ProductRegisterRequest;
import vendingmachine.application.view.ConsoleInputView;
import vendingmachine.application.view.ConsoleOutputView;
import vendingmachine.common.utils.SemiColonParser;

import java.util.List;

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

    public List<ProductRegisterRequest> readRegisteredProductsRequest() {
        outputView.printOnboardingMessage("상품명과 가격, 수량을 입력해 주세요.");
        List<String> productParts = SemiColonParser.split(inputView.readLine());
        return productParts.stream()
                .map(CustomTypeConverter::toProductRegisterRequest)
                .toList();
    }

    public int readCustomerInputAmount() {
        outputView.printOnboardingMessage("투입 금액을 입력해 주세요.");
        return inputView.readNumber();
    }

    public String readPurchasedProductName() {
        outputView.printOnboardingMessage("구매할 상품명을 입력해 주세요.");
        return inputView.readLine();
    }
}
