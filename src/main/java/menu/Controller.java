package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachList;
import menu.domain.menu.MenuOption;
import menu.domain.Service;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.domain.menu.MenuOption.DELIMITER;

public class Controller {
	private final Service service = new Service();

	public void run() {
		OutputView.printStart();
		CoachList coachList = initCoachList();
		initExceptionMenu(coachList);
		List<Integer> categoryOrder = getCategoryOrder();
		service.handleRecommendMenu(categoryOrder, coachList);
		OutputView.printResult(categoryOrder, coachList);
	}

	private CoachList initCoachList() {
		try {
			String value = InputView.readNames();
			List<Coach> coaches = Arrays.stream(value.split(DELIMITER))
					.map(Coach::new)
					.collect(Collectors.toList());
			return new CoachList(coaches);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return initCoachList();
		}
	}

	private void initExceptionMenu(CoachList coachList) {
		coachList.findAll()
				.forEach(this::readExceptionMenu);
	}

	private void readExceptionMenu(Coach coach) {
		try {
			String value = InputView.readExceptionMenu(coach);
			Arrays.stream(value.split(DELIMITER))
					.forEach(coach::addExceptionMenu);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			coach.clearExceptionMenu();
			readExceptionMenu(coach);
		}
	}

	private List<Integer> getCategoryOrder() {
		List<Integer> categoryOrder = new ArrayList<>();
		while (categoryOrder.size() < MenuOption.CATEGORY_SIZE) {
			int legalNumber = getLegalCategoryNumber(categoryOrder);
			categoryOrder.add(legalNumber);
		}
		return categoryOrder;
	}

	private int getLegalCategoryNumber(List<Integer> categoryOrder) {
		int pickNumber = Randoms.pickNumberInRange(MenuOption.CATEGORY_MIN_NUMBER, MenuOption.CATEGORY_MAX_NUMBER);
		int count = (int) categoryOrder.stream().filter(num -> num == pickNumber).count();
		if (count >= MenuOption.CATEGORY_MAX_DUPLICATION) {
			return getLegalCategoryNumber(categoryOrder);
		}
		return pickNumber;
	}

}
