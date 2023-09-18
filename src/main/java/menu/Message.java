package menu;

public enum Message {
	READ_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
	READ_EXCEPTION_MENU("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n"),
	ERROR_PREFIX("[ERROR] : "),
	START_MESSAGE("점심 메뉴 추천을 시작합니다."),
	MENU_RECOMMEND_START("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"),
	MENU_RECOMMEND_END("추천을 완료했습니다."),
	MENU_LIST_FORMAT("[ %s | %s | %s | %s | %s | %s ]\n"),
	CATEGORY_LIST_FORMAT("[ 카테고리 | %s | %s | %s | %s | %s ]\n");

	private final String message;

	Message(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return this.message;
	}
}
