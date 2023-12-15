package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.message.ExceptionMessage;

public class InputView {
    private static int readInteger(String message) {
        System.out.println(message);
        String value = Console.readLine().trim();
        validateBlank(value);
        validateNumber(value);
        return Integer.parseInt(value);
    }

    public static String readString(String message) {
        System.out.println(message);
        String value = Console.readLine().trim();
        validateBlank(value);
        return value;
    }

    private static void validateBlank(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
    }

    private static void validateNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT);
        }
    }
}
