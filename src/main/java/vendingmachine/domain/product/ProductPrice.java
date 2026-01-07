package vendingmachine.domain.product;

import vendingmachine.common.error.DomainException;
import vendingmachine.common.error.ErrorMessage;

import java.util.Objects;

public class ProductPrice {
    private static final int MIN_VALUE = 100;
    private static final int UNIT = 10;
    private static final int REMAIN = 0;

    private final int price;

    public ProductPrice(final int price) {
        validateMinRange(price);
        validatePriceUnit(price);
        this.price = price;
    }

    private void validateMinRange(final int value) {
        if (value < MIN_VALUE) {
            throw new DomainException(ErrorMessage.BELOW_MIN_VALUE, MIN_VALUE);
        }
    }

    private void validatePriceUnit(final int price) {
        if (price % UNIT != REMAIN) {
            throw new DomainException(ErrorMessage.INVALID_PRODUCT_PRICE_UNIT, UNIT);
        }
    }

    public int value() {
        return price;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        ProductPrice integerMaxVO = (ProductPrice) object;
        return price == integerMaxVO.price;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price);
    }
}
