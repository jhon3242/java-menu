package menu;

import menu.domain.MenuOption;

public enum ExceptionMessage {
	SAME_MENU("중복된 메뉴입니다."),
	BLANK("빈 값은 입력 될 수 없습니다."),
	SIZE_EXCEPTION_MENU("못먹는 메뉴는 최대 " + MenuOption.EXCEPTION_MENU_MAX_SIZE + "개입니다."),
	SIZE_COACH_LIST("코치는 최소 2명, 최대 5명이여야 합니다."),
	SIZE_COACH_NAME("코치 이름은 2글자 이상, 4글자 이하이여야 합니다."),
	ILLEGAL_PATTERN("잘못된 형식의 입력입니다."),
	MISMATCH_MENU("메뉴에 없는 이름입니다.  : ");

	private String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
