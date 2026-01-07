package vendingmachine.domain.product;

import vendingmachine.common.error.DomainException;
import vendingmachine.common.error.ErrorMessage;

import java.util.Objects;

public class ProductName {
    private final String name;

    public ProductName(final String name) {
        validateNotEmpty(name);
        this.name = name;
    }

    private void validateNotEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new DomainException(ErrorMessage.BLANK_STRING);
        }
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        ProductName stringMaxLengthVO = (ProductName) object;
        return Objects.equals(name, stringMaxLengthVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
