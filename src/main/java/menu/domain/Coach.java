package menu.domain;

import menu.ExceptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static menu.domain.MenuOption.CHARACTER_REGEX;

public class Coach {
	private String name;
	private ExceptionMenu exceptionMenu;
	private RecommendMenu recommendMenu;

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

	private void validateCoachName(String value) {
		isBlank(value);
		isLegalCharacter(value);
		isLegalLength(value);
	}

	private void isLegalLength(String value) {
		if (value.length() < 2 || value.length() > 4) {
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
