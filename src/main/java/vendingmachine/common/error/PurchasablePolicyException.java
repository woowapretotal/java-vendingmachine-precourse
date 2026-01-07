package vendingmachine.common.error;

public class PurchasablePolicyException extends IllegalStateException {

    public PurchasablePolicyException() {
        super();
    }

    public PurchasablePolicyException(String message) {
        super(message);
    }
}
