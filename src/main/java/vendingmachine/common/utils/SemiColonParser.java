package vendingmachine.common.utils;

import vendingmachine.common.error.ApplicationException;

import java.util.Arrays;
import java.util.List;

import static vendingmachine.common.error.ErrorMessage.EMPTY_SPLITTED_VALUE;

public final class SemiColonParser {
    private static final String SEMI_COLON = ";";

    private SemiColonParser() {
    }

    public static List<String> split(final String commaSeperatedValue) {
        validateNotBlank(commaSeperatedValue);
        return Arrays.stream(commaSeperatedValue.split(SEMI_COLON))
                .map(String::trim)
                .toList();
    }

    private static void validateNotBlank(final String commaSeperatedValue) {
        if (commaSeperatedValue == null || commaSeperatedValue.isBlank()) {
            throw new ApplicationException(EMPTY_SPLITTED_VALUE);
        }
    }
}
