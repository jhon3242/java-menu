package menu.domain.menu;

import menu.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class RecommendMenu {
	private final List<String> store = new ArrayList<>();

	public void addRecommendMenu(String name) {
		validateSameMenu(name);
		store.add(name);
	}

	private void validateSameMenu(String name) {
		if (store.contains(name)) {
			throw new IllegalArgumentException(ExceptionMessage.SAME_MENU.getMessage());
		}
	}

	public String getMenuByIdx(int idx) {
		return store.get(idx);
	}
}
