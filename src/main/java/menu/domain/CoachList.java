package menu.domain;

import java.util.List;

public class CoachList {
	private List<Coach> coachList;

	public CoachList(List<Coach> coachList) {
		validate(coachList);
		this.coachList = coachList;
	}

	private void validate(List<Coach> coachList) {
		if (coachList.size() < 2 || coachList.size() > 5) {
			throw new IllegalArgumentException("코치는 최소 2며으 최대 5명이여야 합니다.");
		}
	}
}
