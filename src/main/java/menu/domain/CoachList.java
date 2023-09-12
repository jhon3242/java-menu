package menu.domain;

import menu.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class CoachList {
	private final List<Coach> coachList;

	public CoachList(List<Coach> coachList) {
		validate(coachList);
		this.coachList = coachList;
	}

	private void validate(List<Coach> coachList) {
		if (coachList.size() < MenuOption.COACH_LIST_MIN_SIZE || coachList.size() > MenuOption.COACH_LIST_MAX_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.SIZE_COACH_LIST.getMessage());
		}
	}

	public List<Coach> findAll() {
		return new ArrayList<>(coachList);
	}
}
