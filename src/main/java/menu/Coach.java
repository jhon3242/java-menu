package menu;

import java.util.List;

public class Coach {
	private String name;
	private List<String> exceptMenus;
	private List<String> alreadyAteMenus;

	public Coach(String name, List<String> exceptMenus, List<String> alreadyAteMenus) {
		this.name = name;
		this.exceptMenus = exceptMenus;
		this.alreadyAteMenus = alreadyAteMenus;
	}

	public boolean canEat(String menu) {
		return !exceptMenus.contains(menu) && !alreadyAteMenus.contains(menu);
	}

	public void addNewAteMenu(String menu) {
		alreadyAteMenus.add(menu);
	}
}
