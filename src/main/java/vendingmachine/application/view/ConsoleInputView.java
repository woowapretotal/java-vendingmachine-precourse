package vendingmachine.application.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.common.utils.TypeConverter;

public class ConsoleInputView {

    public int readNumber() {
        return TypeConverter.toInteger(readLine());
    }

    public double readDecimal() {
        return TypeConverter.toDecimal(readLine());
    }

    public boolean readTF() {
        return TypeConverter.toBoolean(Console.readLine());
    }

    public String readLine() {
        return Console.readLine();
    }
}
