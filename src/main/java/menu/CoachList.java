package menu;

import menu.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoachList {
	private final List<Coach> coachList;

	public CoachList(List<Coach> coachList) {
		validateList(coachList);
		this.coachList = coachList;
	}

	private void validateList(List<Coach> list) {
		if (list == null) {
			throw new IllegalArgumentException(ExceptionMessage.COACH_LIST_NAME);
		}
		if (list.size() < 2 || list.size() > 5) {
			throw new IllegalArgumentException(ExceptionMessage.COACH_LIST_NAME);
		}
	}

	public static CoachList initByString(String input) {
		List<Coach> coaches = Arrays.stream(input.split(","))
				.map(name -> new Coach(name, new ArrayList<>(), new ArrayList<>()))
				.collect(Collectors.toList());
		return new CoachList(coaches);
	}

	@Override
	public String toString() {
		return "CoachList{" +
				"coachList=" + coachList +
				'}';
	}
}
