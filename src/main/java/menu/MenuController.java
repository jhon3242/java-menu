package menu;

import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MenuController {
	private static MenuService menuService = new MenuService(
			MenuRepository.init(),
			new CategoryRepository(new ArrayList<>())
	);

	public static void run() {
		OutputView.printMessage("점심 메뉴 추천을 시작합니다.");
		CoachList coachList = readValidValue(InputView::readCoachList);
		menuService.setCoachList(coachList);

		initExceptionMenus(coachList);
	}

	private static void initExceptionMenus(CoachList coachList) {
		List<Coach> list = coachList.getCoachList();
		list.forEach((coach) -> {
			String exceptionMenu = readValidValue(() -> InputView.readExceptionMenu(coach.getName()));
			coach.addNewExceptionMenu(exceptionMenu);
		});
	}

	public static <T> T readValidValue(Supplier<T> method) {
		try {
			return method.get();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return readValidValue(method);
		}
	}
}
