package menu.view;

import menu.message.ExceptionMessage;
import menu.message.ViewMessage;

public class OutputView {
    public static void printMessage(ViewMessage message) {
        System.out.println(message);
    }

    public static void printException(IllegalArgumentException exception) {
        System.out.println(ViewMessage.ERROR_PREFIX + exception.getMessage());
    }
}
