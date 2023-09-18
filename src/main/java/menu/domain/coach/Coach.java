package menu.domain.coach;

import menu.ExceptionMessage;
import menu.domain.menu.ExceptionMenu;
import menu.domain.menu.RecommendMenu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static menu.domain.coach.CoachOption.COACH_NAME_MAX_SIZE;
import static menu.domain.coach.CoachOption.COACH_NAME_MIN_SIZE;
import static menu.domain.menu.MenuOption.CHARACTER_REGEX;

public class Coach {
	private final String name;
	private final ExceptionMenu exceptionMenu;
	private final RecommendMenu recommendMenu;

	public Coach(String name) {
		validateCoachName(name);
		this.name = name;
		exceptionMenu = new ExceptionMenu();
		recommendMenu = new RecommendMenu();
	}

	public void addExceptionMenu(String name) {
		exceptionMenu.addExceptionMenu(name);
	}

	public void addRecommendMenu(String name) {
		recommendMenu.addRecommendMenu(name);
	}

	public void clearExceptionMenu() {
		exceptionMenu.clearStore();
	}

	private void validateCoachName(String value) {
		isBlank(value);
		isLegalCharacter(value);
		isLegalLength(value);
	}

	private void isLegalLength(String value) {
		if (value.length() < COACH_NAME_MIN_SIZE || value.length() > COACH_NAME_MAX_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.SIZE_COACH_NAME.getMessage());
		}
	}

	private void isBlank(String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException(ExceptionMessage.BLANK.getMessage());
		}
	}

	private void isLegalCharacter(String value) {
		Matcher matcher = Pattern.compile(CHARACTER_REGEX).matcher(value);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_PATTERN.getMessage() + value);
		}
	}

	public String getName() {
		return name;
	}

	public String getMenuByIdx(int idx) {
		return recommendMenu.getMenuByIdx(idx);
	}
}
