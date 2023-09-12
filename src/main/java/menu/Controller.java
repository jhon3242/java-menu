package menu;

import menu.domain.Coach;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
	public void run() {
		OutputView.printStart();
		List<Coach> coaches = initCoachList();
	}

	// todo : 일급 컬랙션으로 리펙터링
	private List<Coach> initCoachList() {
		try {
			String value = InputView.readNames();
			List<Coach> coaches = Arrays.stream(value.split(","))
					.map(Coach::new)
					.collect(Collectors.toList());
			if (coaches.size() < 2 || coaches.size() > 5) {
				throw new IllegalArgumentException("코치는 최소 2며으 최대 5명이여야 합니다.");
			}
			return coaches;
		} catch (IllegalArgumentException e) {
			OutputView.printError(e);
			return initCoachList();
		}
	}
}
