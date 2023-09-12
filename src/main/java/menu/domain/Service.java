package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Service {

	public void handleRecommendMenu(CoachList coachList) {
		List<Integer> categoryOrder = getCategoryOrder();
		categoryOrder.forEach(order -> {
			Menus menus = Menus.findByOrder(order);
			coachList.findAll().forEach(coach -> {
				addRecommendMenu(menus, coach);
			});
		});

	}

	private void addRecommendMenu(Menus menus, Coach coach) {
		try {
			String randomMenu = menus.getRandomMenu();
			coach.addRecommendMenu(randomMenu);
		} catch (IllegalArgumentException e) {
			addRecommendMenu(menus, coach);
		}
	}

	private List<Integer> getCategoryOrder() {
		List<Integer> categoryOrder = new ArrayList<>();
		while (categoryOrder.size() < 5) {
			int legalNumber = getLegalNumber(categoryOrder);
			categoryOrder.add(legalNumber);
		}
		return categoryOrder;
	}

	private int getLegalNumber(List<Integer> categoryOrder) {
		int pickNumber = Randoms.pickNumberInRange(1, 5);
		int count = (int) categoryOrder.stream().filter(num -> num == pickNumber).count();
		if (count >= 2) {
			return getLegalNumber(categoryOrder);
		}
		return pickNumber;
	}

}
