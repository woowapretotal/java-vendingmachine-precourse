package vendingmachine.application.service.request;

public record ProductRegisterRequest(
        String productNane,
        int price,
        int stockQuantity
) {
}
