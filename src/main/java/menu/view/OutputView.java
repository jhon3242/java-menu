package menu.view;

import menu.Message;
import menu.domain.coach.CoachList;
import menu.domain.menu.Menus;

import java.util.List;

public class OutputView {
	public static void printStart() {
		System.out.println(Message.START_MESSAGE);
	}

	public static void printError(Exception e) {
		System.out.println(Message.ERROR_PREFIX + e.getMessage());
	}

	public static void printResult(List<Integer> categoryOrder, CoachList coachList) {
		System.out.println(Message.MENU_RECOMMEND_START);
		printCategory(categoryOrder);
		printRecommendMenu(coachList);
		System.out.println();
		System.out.println(Message.MENU_RECOMMEND_END);
	}

	private static void printRecommendMenu(CoachList coachList) {
		coachList.findAll().forEach(coach -> {
			System.out.printf(Message.MENU_LIST_FORMAT.toString(),
					coach.getName(),
					coach.getMenuByIdx(0),
					coach.getMenuByIdx(1),
					coach.getMenuByIdx(2),
					coach.getMenuByIdx(3),
					coach.getMenuByIdx(4)
					);
		});
	}

	private static void printCategory(List<Integer> categoryOrder) {
		System.out.printf(Message.CATEGORY_LIST_FORMAT.toString(),
				getTypeName(categoryOrder, 0),
				getTypeName(categoryOrder, 1),
				getTypeName(categoryOrder, 2),
				getTypeName(categoryOrder, 3),
				getTypeName(categoryOrder, 4));
	}

	private static String getTypeName(List<Integer> categoryOrder, int idx) {
		Integer order = categoryOrder.get(idx);
		return Menus.findByOrder(order).toString();
	}
}
