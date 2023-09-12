package menu.domain;

import menu.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static menu.domain.MenuOption.CHARACTER_REGEX;

public class Coach {
	private String name;
	private List<String> exceptionMenu;
	private List<String> recommendMenu;

	public Coach(String name) {
		validateName(name);
		this.name = name;
		exceptionMenu = new ArrayList<>();
		recommendMenu = new ArrayList<>();
	}

	public void addExceptionMenu(String name) {
		if (name.isBlank()) return;
		validateExceptionMenu(name);
		exceptionMenu.add(name);
	}

	public void addRecommendMenu(String name) {
		validateSameMenu(name);
		recommendMenu.add(name);
	}

	private void validateSameMenu(String name) {
		if (recommendMenu.contains(name)) {
			throw new IllegalArgumentException(ExceptionMessage.SAME_MENU.getMessage());
		}
	}

	private void validateExceptionMenu(String name) {
		validateSize();
		validateCharactor(name);
		validateContainMenu(name);
	}



	private void validateSize() {
		if (exceptionMenu.size() >= 2) {
			throw new IllegalArgumentException(ExceptionMessage.SIZE_EXCEPTION_MENU.getMessage());
		}
	}

	private void validateCharactor(String name) {
		Matcher matcher = Pattern.compile(CHARACTER_REGEX).matcher(name);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_PATTERN.getMessage());
		}
	}

	private void validateContainMenu(String name) {
		for (Menus menu : Menus.values()) {
			if (menu.containMenu(name)) {
				return;
			}
		}
		throw new IllegalArgumentException(ExceptionMessage.MISMATCH_MENU.getMessage() + name);
	}

	private void validateName(String value) {
		isBlank(value);
		isLegalCharactor(value);
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

	private void isLegalCharactor(String value) {
		Matcher matcher = Pattern.compile(CHARACTER_REGEX).matcher(value);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ExceptionMessage.ILLEGAL_PATTERN.getMessage() + value);
		}
	}

	public String getName() {
		return name;
	}

	public String getMenu(int idx) {
		return recommendMenu.get(idx);
	}
}
