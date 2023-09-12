package menu.view;

import menu.domain.CoachList;
import menu.domain.Menus;

import java.util.List;

public class OutputView {
	public static void printStart() {
		System.out.println("점심 메뉴 추천을 시작합니다.");
	}

	public static void printError(Exception e) {
		System.out.println("[ERROR] : " + e.getMessage());
	}

	public static void printResult(List<Integer> categoryOrder, CoachList coachList) {
		System.out.println("메뉴 추천 결과입니다.");
		System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
		printCategory(categoryOrder);
		printRecommandMenu(coachList);
		System.out.println();
		System.out.println("추천을 완료했습니다.");
	}

	private static void printRecommandMenu(CoachList coachList) {
		coachList.findAll().forEach(coach -> {
			System.out.printf("[ %s | %s | %s | %s | %s | %s ]\n",
					coach.getName(),
					coach.getMenu(0),
					coach.getMenu(1),
					coach.getMenu(2),
					coach.getMenu(3),
					coach.getMenu(4)
					);
		});
	}

	private static void printCategory(List<Integer> categoryOrder) {
		System.out.printf("[ 카테고리 | %s | %s | %s | %s | %s ]\n",
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
