package menu.view;

public class OutputView {
	public static void printStart() {
		System.out.println("점심 메뉴 추천을 시작합니다.");
	}

	public static void printError(Exception e) {
		System.out.println("[ERROR] : " + e.getMessage());
	}
}
