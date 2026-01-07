package vendingmachine.common.utils;

import vendingmachine.common.error.ApplicationException;
import vendingmachine.common.error.ErrorMessage;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TypeConverter {
    private static final String TRUE_BOOLEAN = "Y";
    private static final String FALSE_BOOLEAN = "N";

    public static int toInteger(String line) {
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new ApplicationException(ErrorMessage.INVALID_INTEGER_FORMAT);
        }
    }

    public static double toDecimal(String line) {
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new ApplicationException(ErrorMessage.INVALID_DECIMAL_FORMAT);
        } catch (NullPointerException e) {
            throw new ApplicationException(ErrorMessage.EMPTY_INPUT);
        }
    }

    public static boolean toBoolean(String line) {
        if (line.equals(TRUE_BOOLEAN)) {
            return true;
        }
        if (line.equals(FALSE_BOOLEAN)) {
            return false;
        }

        throw new ApplicationException(ErrorMessage.INVALID_Y_N_FORMAT);
    }

    public static LocalDateTime toLocalDateTime(String line) {
        try {
            return LocalDateTime.parse(line, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeException e) {
            throw new ApplicationException(ErrorMessage.INVALID_DATETIME_FORMAT);
        } catch (NullPointerException e) {
            throw new ApplicationException(ErrorMessage.EMPTY_INPUT);
        }
    }
}
