package menu.domain;

import java.awt.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coach {
	private String name;
	private List<String> exceptionMenu;

	public Coach(String name) {
		validateName(name);
		this.name = name;
	}

	public void addExceptionMenu(String name) {
		exceptionMenu.add(name);
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
