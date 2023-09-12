package menu.domain;

import java.util.List;

public class Service {

	public void handleRecommendMenu(List<Integer> categoryOrder, CoachList coachList) {
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
}
