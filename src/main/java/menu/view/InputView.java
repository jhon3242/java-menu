package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Coach;
import menu.domain.CoachList;

public class InputView {
	public static String readNames() {
		System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
		String value = Console.readLine();
		IOValidate.validateString(value);
		return value;
	}

	public static void readExceptionMenus(CoachList coachList) {
		coachList.findAll()
				.forEach(InputView::readExceptionMenu);
	}

	private static void readExceptionMenu(Coach coach) {
		System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coach.getName());
		String value = Console.readLine();


	}
}
