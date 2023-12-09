package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.CoachList;

public class InputView {
	public static CoachList readCoachList() {
		String input = readString("코치의 이름을 입력해 주세요. (, 로 구분)");
		return CoachList.initByString(input);
	}

	private static String readString(String message) {
		System.out.println(message);
		String input = Console.readLine().trim();
		validateString(input);
		return input;
	}

	private static void validateString(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("빈 값을 입력했습니다.");
		}
	}
}
