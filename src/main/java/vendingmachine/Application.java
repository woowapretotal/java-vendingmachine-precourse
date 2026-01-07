package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.application.controller.VendingMachineController;
import vendingmachine.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        try {
            AppConfig appConfig = new AppConfig();
            VendingMachineController vendingMachineController = appConfig.vendingMachineController();
            vendingMachineController.registerMachineAmountWithRetrying();
        } finally {
            Console.close();
        }
    }
}
