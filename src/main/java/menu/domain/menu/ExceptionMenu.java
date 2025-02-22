package menu.domain.menu;

import menu.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static menu.domain.menu.MenuOption.CHARACTER_REGEX;

public class ExceptionMenu {
	private final List<String> store = new ArrayList<>();

	public void addExceptionMenu(String name) {
		if (name.isBlank()) return;
		validateExceptionMenu(name);
		store.add(name);
	}

	private void validateExceptionMenu(String name) {
		validateSize();
		validateCharacter(name);
		validateContainMenu(name);
	}

	private void validateSize() {
		if (store.size() >= MenuOption.EXCEPTION_MENU_MAX_SIZE) {
			throw new IllegalArgumentException(ExceptionMessage.SIZE_EXCEPTION_MENU.getMessage());
		}
	}

	private void validateCharacter(String name) {
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

	public void clearStore() {
		store.clear();
	}
}
