package vendingmachine.application.controller.adapter;

import vendingmachine.application.service.request.ProductRegisterRequest;
import vendingmachine.common.error.ApplicationException;
import vendingmachine.common.error.ErrorMessage;
import vendingmachine.common.utils.TypeConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomTypeConverter {
    private static final Pattern PRODUCT_PURCHASE_REGEX = Pattern.compile("\\[([가-힣a-zA-Z0-9]+),([0-9]+),([0-9]+)\\]");

    public static ProductRegisterRequest toProductRegisterRequest(String input) {
        Matcher matcher = PRODUCT_PURCHASE_REGEX.matcher(input);
        validatePatternFormat(matcher);

        String name = matcher.group(1);
        int price = TypeConverter.toInteger(matcher.group(2));
        int stockQuantity = TypeConverter.toInteger(matcher.group(3));
        return new ProductRegisterRequest(name, price, stockQuantity);
    }

    private static void validatePatternFormat(final Matcher matcher) {
        if (!matcher.matches()) {
            throw new ApplicationException(ErrorMessage.INVALID_PRODUCT_PURCHASE_FORMAT);
        }
    }
}
