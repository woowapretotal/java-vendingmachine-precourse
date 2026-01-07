package vendingmachine.domain.product;

import vendingmachine.common.error.DomainException;
import vendingmachine.common.error.ErrorMessage;

import java.util.Objects;

public class Stock {
    private static final int MIN_VALUE = 0;

    private final int stockQuantity;

    public Stock(final int stockQuantity) {
        validateMinRange(stockQuantity);
        this.stockQuantity = stockQuantity;
    }

    private void validateMinRange(final int value) {
        if (value < MIN_VALUE) {
            throw new DomainException(ErrorMessage.INSUFFICIENT_STOCK, MIN_VALUE);
        }
    }

    public Stock withDecreaseQuantity(int decreaseQuantity) {
        return new Stock(this.stockQuantity - decreaseQuantity);
    }

    public int value() {
        return stockQuantity;
    }

    public boolean isEmpty() {
        return stockQuantity <= 0;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Stock integerMaxVO = (Stock) object;
        return stockQuantity == integerMaxVO.stockQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stockQuantity);
    }
}
