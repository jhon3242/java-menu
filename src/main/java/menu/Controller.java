package menu;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Coach;
import menu.domain.CoachList;
import menu.domain.Service;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
			List<Coach> coaches = Arrays.stream(value.split(","))
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
			Arrays.stream(value.split(","))
					.forEach(coach::addExceptionMenu);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			readExceptionMenu(coach);
		}
	}

	private List<Integer> getCategoryOrder() {
		List<Integer> categoryOrder = new ArrayList<>();
		while (categoryOrder.size() < 5) {
			int legalNumber = getLegalNumber(categoryOrder);
			categoryOrder.add(legalNumber);
		}
		return categoryOrder;
	}

	private int getLegalNumber(List<Integer> categoryOrder) {
		int pickNumber = Randoms.pickNumberInRange(1, 5);
		int count = (int) categoryOrder.stream().filter(num -> num == pickNumber).count();
		if (count >= 2) {
			return getLegalNumber(categoryOrder);
		}
		return pickNumber;
	}

}
