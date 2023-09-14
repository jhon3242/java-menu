package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.coach.Coach;

public class InputView {
	public static String readNames() {
		System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
		String value = Console.readLine();
		IOValidate.validateString(value);
		return value;
	}

	public static String readExceptionMenu(Coach coach) {
		try {
			System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", coach.getName());
			return Console.readLine();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return readExceptionMenu(coach);
		}
	}
}
