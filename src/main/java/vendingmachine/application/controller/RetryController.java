package vendingmachine.application.controller;

import vendingmachine.application.view.ConsoleOutputView;
import vendingmachine.common.utils.RetryHandler;

import java.util.function.Supplier;

public abstract class RetryController {
    protected final ConsoleOutputView outputView;

    protected RetryController(ConsoleOutputView outputView) {
        this.outputView = outputView;
    }

    protected final <T> T retrying(Supplier<T> supplier) {
        return RetryHandler.execute(supplier, outputView::printErrorMessage);
    }

    protected final void retrying(Runnable runnable) {
        RetryHandler.execute(runnable, outputView::printErrorMessage);
    }
}
