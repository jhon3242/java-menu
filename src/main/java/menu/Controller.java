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
		initExcpetionMenu(coachList);
	}

	private void initExcpetionMenu(CoachList coachList) {
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
