package menu;

import menu.domain.Coach;
import menu.domain.CoachList;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
	public void run() {
		OutputView.printStart();
		CoachList coachList = initCoachList();
	}

	// todo : 일급 컬랙션으로 리펙터링
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
}
