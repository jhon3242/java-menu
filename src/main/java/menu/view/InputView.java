package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.message.ExceptionMessage;
import menu.message.ViewMessage;

public class InputView {
    public static String readString(String message) {
        System.out.println(message);
        String value = Console.readLine().trim();
        validateBlank(value);
        return value;
    }

    public static String readCoachExceptionMenu(Coach coach) {
        System.out.printf(ViewMessage.INPUT_EXCEPTION_MENU_FORMAT, coach.getName());
        return Console.readLine().trim();
    }

    private static void validateBlank(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
    }
}
