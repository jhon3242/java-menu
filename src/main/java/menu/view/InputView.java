package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.Message;
import menu.domain.coach.Coach;

public class InputView {
	public static String readNames() {
		System.out.println(Message.READ_COACH_NAME);
		String value = Console.readLine();
		IOValidate.validateString(value);
		return value;
	}

	public static String readExceptionMenu(Coach coach) {
		try {
			System.out.printf(Message.READ_EXCEPTION_MENU.toString(), coach.getName());
			return Console.readLine();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return readExceptionMenu(coach);
		}
	}
}
