package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coach {
	private String name;
	private List<String> exceptionMenu;

	public Coach(String name) {
		validateName(name);
		this.name = name;
		exceptionMenu = new ArrayList<>();
	}

	public void addExceptionMenu(String name) {
		// todo 예외 처리 필요 (메뉴에 없는 음식)
		if (name.isBlank()) return;
		validateMenu(name);
		exceptionMenu.add(name);
	}

	private void validateMenu(String name) {

		validateSize();
		validateCharactor(name);
	}

	private void validateSize() {
		if (exceptionMenu.size() >= 2) {
			throw new IllegalArgumentException("못먹는 메뉴는 최대 2개입니다.");
		}
	}

	private void validateCharactor(String name) {
		String pattern = "^[\\w가-힣 ]+$";
		Matcher matcher = Pattern.compile(pattern).matcher(name);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("음식 이름이 잘못되었습니다.");
		}
	}


	private void validateName(String value) {
		isBlank(value);
		isLegalCharactor(value);
		isLegalLength(value);
	}

	private void isLegalLength(String value) {
		if (value.length() < 2 || value.length() > 4) {
			throw new IllegalArgumentException("2글자 이상, 4글자 이하이여야 합니다.");
		}
	}

	private void isBlank(String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException("빈 값은 입력 될 수 없습니다.");
		}
	}

	private void isLegalCharactor(String value) {
		String pattern = "^[\\w가-힣]+$";
		Matcher matcher = Pattern.compile(pattern).matcher(value);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("허용되지 않은 코치 이름입니다. : " + value);
		}
	}

	public String getName() {
		return name;
	}
}
