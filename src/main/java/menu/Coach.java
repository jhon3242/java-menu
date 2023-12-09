package menu;

import menu.message.ExceptionMessage;

import java.util.List;

public class Coach {
	private String name;
	private List<String> exceptMenus;
	private List<String> alreadyAteMenus;

	public Coach(String name, List<String> exceptMenus, List<String> alreadyAteMenus) {
		validateName(name);
		this.name = name;
		this.exceptMenus = exceptMenus;
		this.alreadyAteMenus = alreadyAteMenus;
	}

	private void validateName(String name) {
		validateBlank(name);
		validateLength(name);
	}

	private void validateLength(String name) {
		if (name.length() < 2 || name.length() > 4) {
			throw new IllegalArgumentException(ExceptionMessage.COACH_NAME);
		}
	}

	private void validateBlank(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException(ExceptionMessage.BLANK);
		}
	}

	public boolean canEat(String menu) {
		return !exceptMenus.contains(menu) && !alreadyAteMenus.contains(menu);
	}

	public void addNewAteMenu(String menu) {
		alreadyAteMenus.add(menu);
	}

	@Override
	public String toString() {
		return "Coach{" +
				"name='" + name + '\'' +
				", exceptMenus=" + exceptMenus +
				", alreadyAteMenus=" + alreadyAteMenus +
				'}';
	}
}
